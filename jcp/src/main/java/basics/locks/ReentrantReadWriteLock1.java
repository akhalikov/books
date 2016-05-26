package basics.locks;

import java.util.HashMap;
import java.util.Map;

/**
 * Read-reentrant version of {@link SimpleReadWriteLock}
 *
 * A thread is granted read reentrance
 * if it can get read access (no writers or write requests),
 * or if it already has read access (regardless of write requests).
 *
 * To sum up, read reentrancy is only granted if no threads are currently writing to the resource.
 * Additionally, if the calling thread already has read access this takes precedence over any writeRequests.
 *
 * Created by akhalikov on 12.10.2015.
 */
public class ReentrantReadWriteLock1 implements ReadWriteLock {

  /**
   * To determine if a thread has read access already a reference to each thread granted,
   * read access is kept in a Map along with how many times it has acquired read lock.
   * When determing if read access can be granted this Map will be checked for a reference to the calling thread.
   */
  private Map<Thread, Integer> readingThreads = new HashMap();

  private int writers = 0;
  private int writeRequests = 0;

  @Override
  public synchronized void lockRead() {
    Thread callingThread = Thread.currentThread();
    while (!canGrantReadAccess(callingThread)) {
      try {
        wait();
      } catch (InterruptedException e) {
        // Interrupted exceptions should not be swallowed
        // At least, restore the interrupted status like below:
        callingThread.interrupt();
      }
    }

    readingThreads.put(callingThread, getAccessCount(callingThread) + 1);
  }

  @Override
  public synchronized void unlockRead() {
    Thread callingThread = Thread.currentThread();
    int accessCount = getAccessCount(callingThread);
    if (accessCount == 1) {
      readingThreads.remove(callingThread);
    } else {
      readingThreads.put(callingThread, accessCount - 1);
    }
    notifyAll();
  }

  @Override
  public synchronized void lockWrite() {
    // not implemented yet
  }

  @Override
  public void unlockWrite() {
    // not implemented yet
  }

  private boolean canGrantReadAccess(Thread thread) {
    // Can't grant access if there is a writing thread
    if (writers > 0 || writeRequests > 0) return false;
    if (isReader(thread)) return true;
    return true;
  }

  private boolean isReader(Thread thread) {
    return readingThreads.get(thread) != null;
  }

  private int getAccessCount(Thread thread) {
    Integer accessCount = readingThreads.get(thread);
    return (accessCount == null) ? 0 : accessCount.intValue();
  }
}
