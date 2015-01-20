package jcp.book.chapter5.latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by artur on 20.01.15.
 */
public class TestHarness {

    public static void main(String[] args) throws Exception {
        Runnable r = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        System.out.println(timeTask(4, r));
    }

    public static long timeTask(int nThreads, final Runnable task)
    throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        Runnable r = () -> {
            try {
                startGate.await();
                try {
                    task.run();
                } finally {
                    endGate.countDown();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        };
        for (int i = 0; i < nThreads; i++) {
            new Thread(r).start();
        }

        long start = System.nanoTime();
        startGate.countDown();

        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
