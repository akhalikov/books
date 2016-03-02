package careercup.chapter15.deadlockfree;

public class LockFactory {
  private static LockFactory instance;

  private int numberOfLocks = 5;
  private LockNode[] locks;
}
