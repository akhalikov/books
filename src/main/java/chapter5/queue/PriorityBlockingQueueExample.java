package chapter5.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Very simple example of PriorityBlockingQueue usage
 * Created by artur on 23.01.15.
 */
public class PriorityBlockingQueueExample {

    final String[] locations =
            {"Krakow", "Wroclaw", "Kiev", "Odessa", "Sofia", "Bucharest"};

    final BlockingQueue<String> queue = new PriorityBlockingQueue<>();

    public static void main(String[] args) {
        new PriorityBlockingQueueExample().execute();
    }

    void execute() {
        new Thread(() -> {
            for (int i = 0; i < locations.length; i++) {
                try {
                    System.out.println("Put: " + locations[i]);
                    queue.put(locations[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer").start();

        // Locations will be taken from queue in alphabetical order
        new Thread(() -> {
            try {
                for (int i = 0; i < locations.length; i++) {
                    System.out.println("Took: " + queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consumer").start();
    }
}
