package careercup.chapter15.philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A chopstick
 */
public class Chopstick {
  protected final Lock lock = new ReentrantLock();

  public boolean pickUp() {
    lock.lock();
    return true;
  }

  public void putDown() {
    lock.unlock();
  }
}
