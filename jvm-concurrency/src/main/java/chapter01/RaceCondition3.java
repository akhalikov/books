package chapter01;

import java.util.concurrent.TimeUnit;

public class RaceCondition3 {

  private static boolean done;

  // Another solution is to prevent direct access to the done flag and
  // channeling all access through the synchronized getter and setter:

  static synchronized boolean getFlag() { return done; }
  static synchronized void setFlag(boolean flag) { done = flag; }

  // The synchronized keyword makes the calling threads cross the memory barrier
  // both when they enter and when they exit the synchronized block.
  // A thread is guaranteed to see the change made by another thread
  // if both threads synchronize on the same instance and the change-making thread
  // happens before the other thread.

  public static void main(String[] args) throws InterruptedException {
    new Thread(() -> {
      int i = 0;
      while (!getFlag()) {
        i++;
      }
      System.out.println("done! i=" + i);
    }).start();

    System.out.println("OS: " + System.getProperty("os.name"));
    TimeUnit.SECONDS.sleep(2);
    setFlag(true);
    System.out.println("flag done is set to true");
  }
}
