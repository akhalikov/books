package careercup.chapter15.philosophers;

/**
 * Created by akhalikov on 16/02/16
 */
public class LazyPhilosopher extends Philosopher {

  private int bitesRemained = BITES_NUM;

  public LazyPhilosopher(int index, Chopstick left, Chopstick right) {
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
