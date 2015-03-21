package chapter3.counter;

import utils.ThreadRunner;

import static org.junit.Assert.assertEquals;

/**
 * Unsafe counter example #2: although SafeCounter is used,
 * write and read operations are not atomic, so one thread can see value updated by other thread.
 * State of the counter is consistent, but code in runnable is not.
 *
 * Created by artur on 04.01.15.
 */
public class UnsafeCounterExample2 {

    private static final int THREADS_COUNT = 100;

    public static void main(String[] args) throws Exception {
        System.out.println("Unsafe Counter Example #2: start");

        MyRunnable r = new MyRunnable();
        new ThreadRunner(THREADS_COUNT).start(r);
        Thread.sleep(THREADS_COUNT * 20); // to ensure that threads finished their execution

        // Check that value at the end is consistent, i.e. is equal to number of threads
        System.out.println("Counter value=" + r.counter.getValue());
        assertEquals("Inconsistent state detected", THREADS_COUNT, r.counter.getValue());
    }

    private static class MyRunnable implements Runnable {

        private Counter counter = new SafeCounter();

        @Override
        public void run() {
            // increment is safe
            counter.increment();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }

            // Current thread may see value updated by other thread as
            // write and read are not atomic
            System.out.println(Thread.currentThread().getName()
                    + " ["  + counter + "] value=" + counter.getValue());
        }
    }
}
