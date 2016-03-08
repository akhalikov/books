package chapter15.philosophers;

/**
 * A dining philosophers problem
 *
 * Here we're trying to avoid deadlocks by changing behavior of philosophers:
 * they will put down their left chopsticks if the right one is unavailable.
 */
public class LazyStrategy {

  public static void main(String[] args) {

    Chopstick chopstick1 = new LazyChopstick();
    Chopstick chopstick2 = new LazyChopstick();
    Chopstick chopstick3 = new LazyChopstick();
    Chopstick chopstick4 = new LazyChopstick();
    Chopstick chopstick5 = new LazyChopstick();

    Thread p1 = new Thread(new LazyPhilosopher(1, chopstick2, chopstick1));
    Thread p2 = new Thread(new LazyPhilosopher(2, chopstick3, chopstick2));
    Thread p3 = new Thread(new LazyPhilosopher(3, chopstick4, chopstick3));
    Thread p4 = new Thread(new LazyPhilosopher(4, chopstick5, chopstick4));
    Thread p5 = new Thread(new LazyPhilosopher(5, chopstick1, chopstick5));

    p1.start();
    p2.start();
    p3.start();
    p4.start();
    p5.start();
  }
}
