package chapter5.barrier;

import utils.ThreadHelper;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by artur on 20.01.15.
 */
public class CyclicBarrierExample {
    static final int THREADS_NUM = 4;
    static final int MAX_SECONDS = 20;
    static final Random rand = new Random();

    public static void main(String[] args) {
        final int parties = THREADS_NUM;

        // parties specifies how many threads are to sleepSeconds at the created barrier
        CyclicBarrier barrier1 = new CyclicBarrier(parties,
                () -> System.out.println("Barrier Action 1 executed"));

        CyclicBarrier barrier2 = new CyclicBarrier(parties,
                () -> System.out.println("Barrier Action 2 executed"));

        for (int i = 0; i < parties; i++) {
            new Thread(new BarrierRunnable(barrier1, barrier2)).start();
        }
    }

    static class BarrierRunnable implements Runnable {
        CyclicBarrier barrier1, barrier2;

        public BarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
            this.barrier1 = barrier1;
            this.barrier2 = barrier2;
        }

        @Override
        public void run() {
            try {
                int waitInterval = rand.nextInt(MAX_SECONDS);
                final String threadName = Thread.currentThread().getName();

                System.out.println(threadName + " execution time: " + waitInterval + "s");
                ThreadHelper.sleepSeconds(waitInterval);
                System.out.println(threadName + " waiting at barrier 1");
                // Here threads sleepSeconds on first barrier
                barrier1.await();

                waitInterval = rand.nextInt(MAX_SECONDS);
                System.out.println(threadName + " execution time: " + waitInterval + "s");
                ThreadHelper.sleepSeconds(waitInterval);
                System.out.println(threadName + " waiting at barrier 2");
                // Here threads sleepSeconds on second barrier
                // one can also specify timeout of waiting
                barrier2.await(MAX_SECONDS+1, TimeUnit.SECONDS);

                System.out.println(Thread.currentThread().getName() + " done!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
    }
}
