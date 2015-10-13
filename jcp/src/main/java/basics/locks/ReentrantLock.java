package basics.locks;

/**
 * Simple reentrant lock implementation
 *
 * Compared to {@link SimpleLock}, the while loop (spin lock) now also takes the thread
 * that locked the Lock instance into consideration.
 *
 * If either the lock is unlocked (isLocked = false) or the calling thread is the thread that locked the Lock instance,
 * the while loop will not execute, and the thread calling lock() will be allowed to exit the method.
 *
 * Additionally, we need to count the number of times the lock has been locked by the same thread.
 * Otherwise, a single call to unlock() will unlock the lock, even if the lock has been locked multiple times.
 * We don't want the lock to be unlocked until the thread that locked it,
 * has executed the same amount of unlock() calls as lock() calls.
 *
 * {@See http://tutorials.jenkov.com/java-concurrency/locks.html}
 */
public class ReentrantLock implements Lock {

    private boolean isLocked = false;
    private Thread lockedBy = null;
    private int lockedCount = 0;


    @Override
    public synchronized void lock() {
        Thread callingThread = Thread.currentThread();
        while (isLocked && lockedBy != callingThread) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Interrupted exceptions should not be swallowed
                // At least, restore the interrupted status like below:
                Thread.currentThread().interrupt();
            }
        }
        isLocked = true;
        lockedCount++;
        lockedBy = callingThread;
    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }
}
