package chapter5.queue;

import com.ahalikov.toolkit.threads.*;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Very simple example of BlockingDeque usage
 * Created by artur on 23.01.15.
 */
public class BlockingDequeExample {

    static final boolean IS_FIFO_QUEUE = false;

    final String[] locations =
            {"Krakow", "Wroclaw", "Kiev", "Odessa", "Sofia", "Bucharest"};

    final BlockingDeque<String> queue = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        new BlockingDequeExample().execute();
    }

    void execute() {
        new Thread(() -> {
            for (int i = 0; i < locations.length; i++) {
                try {
                    if (IS_FIFO_QUEUE) {
                        System.out.println("Put: " + locations[i]);
                        queue.put(locations[i]);
                    } else {
                        System.out.println("Put last: " + locations[i]);
                        queue.putLast(locations[i]);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < locations.length; i++) {
                    if (IS_FIFO_QUEUE) {
                        System.out.println("Took: " + queue.take());
                    } else {
                        System.out.println("Took first: " + queue.takeFirst());
                    }
                    ThreadHelper.sleepRandomSeconds(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer").start();
    }
}
