package chapter15.philosophers;

/**
 * Dining philosophers problem
 *
 * Such design exposes appearance of potential deadlocks
 */
public class EagerStrategy {

  public static void main(String[] args) {
    for (int i = 0; i < 1_000; ++i)
      startDinner();
  }

  static void startDinner() {
    Chopstick chopstick1 = new Chopstick();
    Chopstick chopstick2 = new Chopstick();
    Chopstick chopstick3 = new Chopstick();
    Chopstick chopstick4 = new Chopstick();
    Chopstick chopstick5 = new Chopstick();

    Thread p1 = new Thread(new Philosopher(1, chopstick2, chopstick1));
    Thread p2 = new Thread(new Philosopher(2, chopstick3, chopstick2));
    Thread p3 = new Thread(new Philosopher(3, chopstick4, chopstick3));
    Thread p4 = new Thread(new Philosopher(4, chopstick5, chopstick4));
    Thread p5 = new Thread(new Philosopher(5, chopstick1, chopstick5));

    p1.start();
    p2.start();
    p3.start();
    p4.start();
    p5.start();
  }
}
