package chapter5.semaphore;

import utils.ThreadHelper;

import java.util.concurrent.Semaphore;

/**
 * This example to show a degenerative case of semaphore
 * as a binary semaphore, which can be used as a mutex,
 * with non-reentrant locking semantics.
 *
 * Created by artur on 25.02.15.
 */
public class SemaphoreMutex {

    static final int PAUSE_SEC = 3;
    static final int THREADS_NUM = 5;

    public static void main(String[] args) {
        final Semaphore mutexSemaphore = new Semaphore(1);

        // Expected that crytical section will be entered by one thread at a time
        for (int i = 0; i < THREADS_NUM; i++) {
            new Thread(() -> {
                try {
                    mutexSemaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " is entered critical section");
                    ThreadHelper.sleepSeconds(PAUSE_SEC);

                    System.out.println(Thread.currentThread().getName() + " released");
                    mutexSemaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
