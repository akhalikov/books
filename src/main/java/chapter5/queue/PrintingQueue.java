package chapter5.queue;

import utils.ThreadHelper;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Given two threads, one thread prints "0", other prints "1" consequently
 *
 * @author ahalikov
 */
public class PrintingQueue {

    public static void main(String[] args) throws Exception {
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue(1);
        queue.add(0);

        Thread t1 = new Thread(new PrintingThread(queue));
        Thread t2 = new Thread(new PrintingThread(queue));

        t1.start();
        t2.start();

        t2.join();
    }

    static class PrintingThread implements Runnable {

        final BlockingQueue<Integer> queue;

        public PrintingThread(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int value = queue.take();
                    ThreadHelper.clog("" + value);
                    queue.add(value == 0 ? 1 : 0);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
