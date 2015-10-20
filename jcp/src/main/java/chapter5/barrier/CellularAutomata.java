package chapter5.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Listing 5.15. Coordinating Computation in a Cellular Automaton with CyclicBarrier
 *
 * CellularAutomata in Listing 5.15 demonstrates using a barrier to compute a cellular
 * automata simulation, such as Conway's Life game (Gardner, 1970).
 * When parallelizing a simulation, it is generally impractical to assign a separate
 * thread to each element (in the case of Life, a cell); this would require too many threads,
 * and the overhead of coordinating them would dwarf the computation.
 *
 * Instead, it makes sense to partition the problem into a number of subparts,
 * let each thread solve a subpart, and then merge the results.
 * CellularAutomata partitions the board into Ncpu parts, where Ncpu is the number of CPUs available,
 * and assigns each part to a thread. [5] At each step, the worker threads
 * calculate new values for all the cells in their part of the board.
 *
 * When all worker threads have reached the barrier, the barrier action
 * commits the new values to the data model. After the barrier action runs,
 * the worker threads are released to compute the next step of the calculation,
 * which includes consulting an isDone method to determine whether further iterations are required.
 *
 * @author ahalikov
 */
class CellularAutomata {

    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    CellularAutomata(Board board) {
        this.mainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, () -> mainBoard.commitNewValues());
        this.workers = new Worker[count];
        for (int i = 0; i < count; i++)
            workers[i] = new Worker(mainBoard.getSubBoard(count, i));
    }

    private class Worker implements Runnable {
        private final Board board;

        public Worker(Board board) { this.board = board; }

        public void run() {
            while (!board.hasConverged()) {
                for (int x = 0; x < board.getMaxX(); x++)
                    for (int y = 0; y < board.getMaxY(); y++)
                        board.setNewValue(x, y, computeValue(x, y));
                try {
                    barrier.await();
                } catch (InterruptedException ex) {
                    return;
                } catch (BrokenBarrierException ex) {
                    return;
                }
            }
        }

        int computeValue(int x, int y) {
            // some random computation
            return (x * y) * 42;
        }
    }

    public void start() {
        for (int i = 0; i < workers.length; i++)
            new Thread(workers[i]).start();

        mainBoard.waitForConvergence();
    }

    interface Board {

        int getMaxX();

        int getMaxY();

        int getValue(int x, int y);

        int setNewValue(int x, int y, int value);

        void commitNewValues();

        boolean hasConverged();

        void waitForConvergence();

        Board getSubBoard(int numPartitions, int index);
    }
}
