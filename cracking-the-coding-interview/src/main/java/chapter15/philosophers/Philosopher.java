package chapter15.philosophers;

/**
 * Eager philosopher is kind of bad-ass, he either eat with both
 * left and right chopsticks, or wait.
 */
class Philosopher implements Runnable {
  static final int BITES_NUM = 10;

  protected int index;
  protected Chopstick left, right;
  int eatCounter = 0;

  Philosopher() {
  }

  Philosopher(int index, Chopstick left, Chopstick right) {
    this.index = index;
    this.left = left;
    this.right = right;
  }

  public void eat() {
    pickUp();
    chew();
    putDown();
    eatCounter++;
  }

  void chew() {
    // eating
  }

  public boolean pickUp() {
    left.pickUp();
    right.pickUp();
    return true;
  }

  void putDown() {
    right.putDown();
    left.putDown();
  }

  @Override
  public void run() {
    for (int i = 0; i < BITES_NUM; i++) {
      eat();
    }
    printFinished();
  }

  private void printFinished() {
    String msg;
    if (eatCounter == 0)
      msg = "left hungry";
    else if (eatCounter < BITES_NUM)
      msg = eatCounter + " bites left";
    else
      msg = "finished";
    System.out.println(name() + ": " + msg);
  }

  private String name() {
    return "p" + index;
  }
}
