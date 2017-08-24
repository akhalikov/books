package chapter15.philosophers;

/**
 * Prioritized philosopher
 * <p>
 * Attempts to pick up a chopstick with lower priority, i.e. the left one.
 */
class PriorityPhilosopher extends Philosopher {

  PriorityPhilosopher(int index,
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
