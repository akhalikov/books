package chapter15.deadlockfree;

class LockFactory {
  private static LockFactory instance;

  private int numberOfLocks = 5;
  private LockNode[] locks;
}
