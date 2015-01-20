package jcp.book.chapter5.latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by artur on 20.01.15.
 */
public class ServicesStartupExample {
    static final int SERVICES_NUM = 3;

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(SERVICES_NUM);

        Service[] services = new Service[] {
                new Service("CacheService", 2000, latch),
                new Service("VerificationService", 1000, latch),
                new Service("ExportService", 5000, latch)
        };
        for (Service service: services) {
            new Thread(service).start();
        }

        // waiting for all services to start
        // the main thread will wait until countdown of latch reaches 0
        System.out.println("Waiting for services to start...");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All services are up, the application can proceed with starting!");
    }

    /**
     * Generic service that count downs the latch when starting
     */
    static class Service implements Runnable {
        private final String name;
        private final int timeToStartMs;
        private final CountDownLatch latch;

        public Service(String name, int timeToStartMs, CountDownLatch latch) {
            this.name = name;
            this.timeToStartMs = timeToStartMs;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeToStartMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + " is up");
            latch.countDown();
        }
    }
}
