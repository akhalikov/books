package basics.locks;

/**
 * Read write lock interface
 *
 * @author ahalikov
 */
public interface ReadWriteLock {
  void lockRead();
  void unlockRead();
  void lockWrite();
  void unlockWrite();
}
