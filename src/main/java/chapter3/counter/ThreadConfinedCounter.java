package chapter3.counter;

import utils.ThreadRunner;

/**
 * UnsafeCounter confined to ThreadLocal
 *
 * Created by artur on 04.01.15.
 */
public class ThreadConfinedCounter {

    public static void main(String[] args) {
        new ThreadRunner(2).start(new MyRunnable());
    }

    static class MyRunnable implements Runnable {
        private ThreadLocal<UnsafeCounter> counterHolder = new ThreadLocal<UnsafeCounter>() {
            @Override
            protected UnsafeCounter initialValue() {
                return new UnsafeCounter();
            }
        };

        @Override
        public void run() {

            // Each thread gets and sets different UnsafeCounter object,
            // i.e. threads don't see each other values

            UnsafeCounter counter = counterHolder.get();
            counter.increment();
            System.out.println(Thread.currentThread().getName()
                    + " ["  + counter + "] value=" + counter.getValue());
            counterHolder.set(counter);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}
