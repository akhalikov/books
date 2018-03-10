package chapter01;

import java.util.concurrent.TimeUnit;

public class RaceCondition {
  private static boolean done;

  public static void main(String[] args) throws InterruptedException {
    new Thread(() -> {
      int i = 0;
      while (!done) {
        i++;
      }
      System.out.println("done! i=" + i);
    }).start();

    System.out.println("OS: " + System.getProperty("os.name"));
    TimeUnit.SECONDS.sleep(2);
    done = true;
    System.out.println("flag done is set to true");
  }
}
