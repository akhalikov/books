package careercup.chapter15.philosophers;

/**
 * Prioritized philosopher
 *
 * Attempts to pick up a chopstick with lower priority, i.e. the left one.
 *
 * Created by akhalikov on 17/02/16
 */
public class PriorityPhilosopher extends Philosopher {

  public PriorityPhilosopher(int index,
                             PriorityChopstick left,
                             PriorityChopstick right) {
    this.index = index;
    if (left.getPriority() < right.getPriority()) {
      this.left = left;
      this.right = right;
    } else {
      this.left = right;
      this.right = left;
    }
  }
}
