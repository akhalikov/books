package chapter5.queue;

import com.ahalikov.toolkit.threads.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Simplest BlockingQueue example ever
 *
 * Represents Producer-Consumer pattern that lies beneath BlockingQueue
 *
 * Created by artur on 20.01.15.
 */
public class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(1024);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

    static class Producer implements Runnable {
        final BlockingQueue queue;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                System.out.println("Taking 1st value: ");
                System.out.println(queue.take());

                System.out.println("Taking 2nd value: ");
                System.out.println(queue.take());

                System.out.println("Taking 3rd value: ");
                System.out.println(queue.take());

                // what if to take extra value?
                // current thread will be blocked forever

                System.out.println("Taking 4th and last value: ");
                System.out.println(queue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("All values are taken");
        }
    }

    static class Consumer implements Runnable {
        final BlockingQueue queue;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                queue.put("1");

                ThreadHelper.sleepRandomSeconds(5);
                queue.put("2");

                ThreadHelper.sleepRandomSeconds(7);
                queue.put("3");

                ThreadHelper.sleepSeconds(1);
                System.out.println("Waiting 10 sec. before put last value...");
                ThreadHelper.sleepSeconds(10);
                queue.put("4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
