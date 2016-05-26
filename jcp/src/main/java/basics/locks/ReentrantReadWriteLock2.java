package basics.locks;

import java.util.HashMap;
import java.util.Map;

/**
 * Write-reentrant read-write lock.
 * Write reentrance is granted only if the thread has already write access.
 *
 * {@See http://tutorials.jenkov.com/java-concurrency/read-write-locks.html}
 */
public class ReentrantReadWriteLock2 implements ReadWriteLock {

  private Map<Thread, Integer> readingThreads = new HashMap();

  private int writeAccesses = 0;
  private int writeRequests = 0;
  private Thread writingThread = null;

  @Override
  public synchronized void lockWrite() {
    writeRequests++;
    Thread callingThread = Thread.currentThread();
    while (!canGrantWriteAccess(callingThread)) {
      try {
        wait();
      } catch (InterruptedException e) {
        // Interrupted exceptions should not be swallowed
        // At least, restore the interrupted status like below:
        callingThread.interrupt();
      }
    }
    writeRequests--;
    writeAccesses++;
    writingThread = callingThread;
  }

  @Override
  public synchronized void unlockWrite() {
    writeAccesses--;
    if (writeAccesses == 0) {
      writingThread = null;
    }
    notifyAll();
  }

  private boolean canGrantWriteAccess(Thread thread) {
    if (hasReaders()) return false;
    if (writingThread == null) return true;
    if (!isWriter(thread)) return false;
    return true;
  }

  private boolean hasReaders() {
    return readingThreads.size() > 0;
  }

  private boolean isWriter(Thread thread) {
    return writingThread == thread;
  }

  @Override
  public void lockRead() {
  }

  @Override
  public void unlockRead() {
  }
}
