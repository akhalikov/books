package careercup.chapter15.philosophers;

/**
 * A chopstick
 */
public class PriorityChopstick extends Chopstick {
  private int priority;

  public PriorityChopstick(int priority) {
    this.priority = priority;
  }

  public int getPriority() {
    return priority;
  }
}
