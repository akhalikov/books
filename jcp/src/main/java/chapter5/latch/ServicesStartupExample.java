package chapter5.latch;

import static com.ahalikov.toolkit.threads.ThreadHelper.*;

import java.util.concurrent.CountDownLatch;

/**
 * A latch is used to make the main thread wait
 * until three other threads complete their execution.
 * These three threads model starting services.
 * So the example models scenario when a program should wait until
 * some services complete their initialization.
 *
 * Created by artur on 20.01.15.
 */
public class ServicesStartupExample {
    static final int SERVICES_NUM = 3;

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(SERVICES_NUM);

        Service[] services = new Service[] {
                new Service("CacheService", 2, latch),
                new Service("VerificationService", 1, latch),
                new Service("ExportService", 5, latch)
        };
        for (Service service: services) {
            new Thread(() -> service.startUp()).start();
        }

        // waiting for all services to start
        // the main thread will sleepSeconds until countdown of latch reaches 0
        clog("Waiting for services to start...");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clog("All services are up, the application can proceed with starting!");
    }

    /**
     * Generic service that count downs the latch when starting
     */
    static class Service {
        private final String name;
        private final int timeToStartSec;
        private final CountDownLatch latch;

        public Service(String name, int timeToStartSec, CountDownLatch latch) {
            this.name = name;
            this.timeToStartSec = timeToStartSec;
            this.latch = latch;
        }

        public void startUp() {
            sleepSeconds(timeToStartSec);
            System.out.println(name + " is up");
            latch.countDown();
        }
    }
}
