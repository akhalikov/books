package chapter10.item66;

import java.util.concurrent.TimeUnit;

public class StopThreadVolatile {
  private static volatile boolean stopRequested;
  private static int iterations = 0;

  public static void main(String[] args) throws InterruptedException {

    Thread backgroundThread = new Thread(() -> {
      while (!stopRequested) {
        iterations++;
      }
    });

    backgroundThread.start();

    TimeUnit.MILLISECONDS.sleep(10);

    stopRequested = true;

    System.out.println("iterations=" + iterations);
  }
}
