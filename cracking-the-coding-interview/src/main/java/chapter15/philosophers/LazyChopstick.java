package chapter15.philosophers;

/**
 * LazyChopstick can be picked up only if it is free
 */
public class LazyChopstick extends Chopstick {

  public boolean pickUp() {
    return lock.tryLock();
  }
}
