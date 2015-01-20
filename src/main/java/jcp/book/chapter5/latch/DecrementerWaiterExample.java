package jcp.book.chapter5.latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by artur on 20.01.15.
 */
public class DecrementerWaiterExample {

    static final int COUNT_NUM = 3;

    public static void main(String[] args) throws Exception {
        final CountDownLatch latch = new CountDownLatch(COUNT_NUM);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(decrementer).start();
        new Thread(waiter).start();

        Thread.sleep(4000);
    }

    static class Decrementer implements Runnable {
        CountDownLatch latch = null;

        public Decrementer(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= COUNT_NUM; i++) {
                    Thread.sleep(1000);
                    System.out.println("Counting " + i);
                    latch.countDown();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
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
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Waiter released");
        }
    }
}
