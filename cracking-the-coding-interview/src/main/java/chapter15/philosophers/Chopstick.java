package chapter15.philosophers;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A chopstick
 */
public class Chopstick {
  final Lock lock = new ReentrantLock();

  public boolean pickUp() {
    lock.lock();
    return true;
  }

  void putDown() {
    lock.unlock();
  }
}
