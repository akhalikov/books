package chapter3.counter;

import utils.ThreadRunner;

import static org.junit.Assert.assertEquals;

/**
 * Synchronized UnsafeCounter
 *
 * Created by artur on 04.01.15.
 */
public class SafeCounterExample2 {

    private static final int EXECUTIONS_COUNT = 10;
    private static final int THREADS_COUNT = 50;

    public static void main(String[] args) throws Exception {
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

            // atomic write and read
            synchronized (this) {
                counter.increment();
                System.out.println(Thread.currentThread().getName()
                        + " [" + counter + "] value=" + counter.getValue());
            }
        }
    }
}
