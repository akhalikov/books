package chapter5.latch;

import static com.ahalikov.toolkit.threads.ThreadHelper.*;

import java.util.concurrent.CountDownLatch;

/**
 * One thread is waiting on CountingDownLatch
 * while other thread updates the latch.
 *
 * If exception occurs during run of Decrementer thread,
 * Waiter thread will never release the latch.
 *
 * Created by artur on 20.01.15.
 */
public class FailedDecrementerWaiterExample {

    static final int COUNT_NUM = 3;

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(COUNT_NUM);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(decrementer, "DecrementerThread").start();
        new Thread(waiter, "WaiterThread").start();

        sleepSeconds(4);
    }

    static class Decrementer implements Runnable {
        CountDownLatch latch = null;

        public Decrementer(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            clog("started");
            for (int i = 1; i <= COUNT_NUM; i++) {
                if (i == 3) {
                    throw new RuntimeException("Decrementer failed");
                }
                sleepSeconds(1);
                clog("counting " + i);
                latch.countDown();
            }
        }
    }

    static class Waiter implements Runnable {
        CountDownLatch latch = null;

        public Waiter(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            clog("started");
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clog("waiter released");
        }
    }
}
