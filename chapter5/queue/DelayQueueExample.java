package chapter5.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Simple DelayQueue usage example
 *
 * Created by artur on 20.01.15.
 */
public class DelayQueueExample {

    public static void main(String[] args) throws Exception {
        // This queue is unbounded
        DelayQueue queue = new DelayQueue();

        Delayed item1 = new DelayedItem("Brew Dog", 5);
        queue.put(item1);

        System.out.println("Taking delayed item, thread should wait 5 sec...");
        System.out.println("Got it: " + queue.take());
    }

    static class DelayedItem implements Delayed {
        final String name;
        final int delaySeconds;
        final long startTime;

        public DelayedItem(String name, int delaySeconds) {
            this.name = name;
            this.delaySeconds = delaySeconds;
            this.startTime = System.currentTimeMillis() + delaySeconds*1000;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long diff = startTime - System.currentTimeMillis();
            return unit.convert(diff, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return this.getDelay(TimeUnit.SECONDS) <= o.getDelay(TimeUnit.SECONDS) ? -1: 1;
        }

        @Override
        public String toString() {
            return "DelayedItem{" +
                    "name='" + name + '\'' +
                    ", delaySeconds=" + delaySeconds +
                    '}';
        }
    }
}
