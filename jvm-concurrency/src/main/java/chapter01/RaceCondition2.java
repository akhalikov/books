package chapter01;

import java.util.concurrent.TimeUnit;

public class RaceCondition2 {

  // The volatile keyword (1) tells JIT not to perform any optimizations that may affect
  // the ordering of access to that variable
  // (2) read or write to that variable should bypass cache and go straight to memory
  // cons: poor performance as every access should cross memory barrier and lack of atomicity
  private static volatile boolean done;

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
