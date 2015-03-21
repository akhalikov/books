package chapter3.counter;

import utils.ThreadRunner;

import static org.junit.Assert.assertEquals;

/**
 * Unsafe counter example #1: example of how using of non-atomic increment
 * from multiple threads may cause inconsistent state of shared variable
 *
 * Created by artur on 04.01.15.
 */
public class UnsafeCounterExample1 {

    private static final int EXECUTIONS_COUNT = 30;
    private static final int THREADS_COUNT = 100;

    public static void main(String[] args) throws Exception {
        System.out.println("Unsafe Counter Example #1: start");

        for (int i = 0; i < EXECUTIONS_COUNT; i++)
            execute(i);
    }

    private static void execute(int executionId) throws Exception {
        MyRunnable r = new MyRunnable();
        new ThreadRunner(THREADS_COUNT).start(r);
        Thread.sleep(THREADS_COUNT * 20); // to ensure that threads finished their execution

        // Check that value at the end is consistent, i.e. is equal to number of threads
        System.out.println("#" + executionId + ", counter value=" + r.counter.getValue());
        assertEquals("Inconsistent state detected at execution #" + executionId,
                THREADS_COUNT, r.counter.getValue());
    }

    private static class MyRunnable implements Runnable {
        private Counter counter = new UnsafeCounter();

        @Override
        public void run() {
            // Not safe (non-atomic) increment
            counter.increment();
        }
    }
}
