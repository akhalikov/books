package chapter15.philosophers;

public class LazyPhilosopher extends Philosopher {

  LazyPhilosopher(int index, Chopstick left, Chopstick right) {
    super(index, left, right);
  }

  @Override
  public void eat() {
    if (pickUp()) {
      chew();
      putDown();
      eatCounter++;
    }
  }

  @Override
  public boolean pickUp() {
    if (!left.pickUp())
      return false;
    if (!right.pickUp()) {
      left.putDown();
      return false;
    }
    return true;
  }
}
