package chapter5.semaphore;

import utils.ThreadHelper;

import java.util.concurrent.Semaphore;

/**
 * Main semaphore scenario of guarding critical section
 * against entry by more than N threads at a time.
 *
 * Created by artur on 21.01.15.
 */
public class CountingSemaphore {
    static final int THREADS_NUM = 7;
    static final int PERMITTED_NUM = 2;

    public static void main(String[] args) {
        // Creating semaphore for permittedNum threads
        final Semaphore semaphore = new Semaphore(PERMITTED_NUM);

        // Expecting that first 3 threads will enter critical section,
        // and the 4th and 5th threads will go after they release
        for (int i = 0; i < THREADS_NUM; i++) {
            new Thread(() -> {
                try {
                    // No guarantees are made about fairness of the threads
                    // acquiring permits from the Semaphore.
                    // That is, there is no guarantee that the first thread to call acquire()
                    // is also the first thread to obtain a permit.
                    System.out.println(Thread.currentThread().getName() + " has acquired lock");
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName() + " is entered critical section");
                    ThreadHelper.sleepSeconds(6);

                    System.out.println(Thread.currentThread().getName() + " released");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
