package basics.locks;

/**
 * Basic implementation of read-write lock
 * Not reentrant
 *
 * Read Access  -> If no threads are writing, and no threads have requested write access.
 * Write Access -> If no threads are reading or writing.
 *
 * Both unlockRead() and unlockWrite() calls notifyAll() rather than notify().
 * To explain why that is, imagine the following situation:
 *
 * Inside the ReadWriteLock there are threads waiting for read access, and threads waiting for write access.
 * If a thread awakened by notify() was a read access thread, it would be put back to waiting because there are threads
 * waiting for write access. However, none of the threads awaiting write access are awakened, so nothing more happens.
 * No threads gain neither read nor write access. By calling noftifyAll() all waiting threads are awakened and check
 * if they can get the desired access.
 *
 * Calling notifyAll() also has another advantage. If multiple threads are waiting for read access and none for write
 * access, and unlockWrite() is called, all threads waiting for read access are granted read access at once - not one by one.
 */
public class SimpleReadWriteLock implements ReadWriteLock {
  private int readers = 0;
  private int writers = 0;
  private int writeRequests = 0;

  @Override
  public synchronized void lockRead() {
    while (writers > 0 || writeRequests > 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    readers++;
  }

  @Override
  public synchronized void unlockRead() {
    readers--;
    notifyAll();
  }

  @Override
  public void lockWrite() {
    writeRequests++;
    while (readers > 0 || writers > 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        // Interrupted exceptions should not be swallowed
        // At least, restore the interrupted status like below:
        Thread.currentThread().interrupt();
      }
    }
    writeRequests--;
    writers++;
  }

  @Override
  public void unlockWrite() {
    writers--;
    notifyAll();
  }
}
