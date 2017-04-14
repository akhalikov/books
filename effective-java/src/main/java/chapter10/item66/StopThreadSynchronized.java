package chapter10.item66;

import java.util.concurrent.TimeUnit;

/**
 * Chapter 10
 * Item 66: Synchronize access to shared mutable data
 *
 *  Properly synchronized cooperative thread termination.
 *  The program terminates in about one second.
 */
public class StopThreadSynchronized {

  private static boolean stopRequested;

  private static long iterations = 0;

  // write synchronization
  // though reads and writes to boolean field are atomic, we still need synchronization
  // to achieve visibility.
  //
  // synchronization is used here only for communication effects, not for mutual exclusion.
  private static synchronized void requestStop() {
    stopRequested = true;
  }

  // read synchronization
  private static synchronized boolean isStopRequested() {
    return stopRequested;
  }

  public static void main(String[] args) throws InterruptedException {

    Thread backgroundThread = new Thread(() -> {
      while (!isStopRequested()) {
        iterations++;
      }
    });

    backgroundThread.start();

    TimeUnit.MILLISECONDS.sleep(10);

    requestStop();

    System.out.println("iterations=" + iterations);
  }
}
