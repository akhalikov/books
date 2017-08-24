package chapter15.philosophers;

class PriorityChopstick extends Chopstick {
  private int priority;

  PriorityChopstick(int priority) {
    this.priority = priority;
  }

  int getPriority() {
    return priority;
  }
}
