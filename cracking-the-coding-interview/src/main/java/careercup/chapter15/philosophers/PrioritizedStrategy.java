package careercup.chapter15.philosophers;

/**
 * Avoiding deadlocks with priorities
 */
public class PrioritizedStrategy {

  public static void main(String[] args) {
    startDinner();
  }

  static void startDinner() {
    PriorityChopstick chopstick1 = new PriorityChopstick(1);
    PriorityChopstick chopstick2 = new PriorityChopstick(2);
    PriorityChopstick chopstick3 = new PriorityChopstick(3);
    PriorityChopstick chopstick4 = new PriorityChopstick(4);
    PriorityChopstick chopstick5 = new PriorityChopstick(5);

    Thread p1 = new Thread(new PriorityPhilosopher(1, chopstick2, chopstick1));
    Thread p2 = new Thread(new PriorityPhilosopher(2, chopstick3, chopstick2));
    Thread p3 = new Thread(new PriorityPhilosopher(3, chopstick4, chopstick3));
    Thread p4 = new Thread(new PriorityPhilosopher(4, chopstick5, chopstick4));
    Thread p5 = new Thread(new PriorityPhilosopher(5, chopstick1, chopstick5));

    p1.start();
    p2.start();
    p3.start();
    p4.start();
    p5.start();
  }
}
