package chapter15.deadlockfree;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class LockNode {
  public enum VisitState { FRESH, VISITING, VISITED };

  private ArrayList<LockNode> children;
  private int lockId;
  private Lock lock;
  private int maxLocks;

  public LockNode(int id, int max) {

  }

  public void joinTo(LockNode node) {

  }
}
