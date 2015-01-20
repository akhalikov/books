package chapter5;

import utils.ThreadHelper;

import java.util.concurrent.Semaphore;

/**
 * Semaphore scenario of guarding critical section
 * against entry by more than N threads at a time.
 *
 * Created by artur on 21.01.15.
 */
public class SemaphoreExample1 {
    static final int THREADS_NUM = 5;

    public static void main(String[] args) {
        final int permittedNum = THREADS_NUM - 2;

        // Creating semaphore for permittedNum threads
        final Semaphore semaphore = new Semaphore(permittedNum);

        // Expecting that first 3 threads will enter critical section,
        // and the 4th and 5th threads will go after they release
        for (int i = 0; i < THREADS_NUM; i++) {
            new Thread(() -> {
                try {
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
