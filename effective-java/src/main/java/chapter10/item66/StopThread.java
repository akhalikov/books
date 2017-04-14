package chapter10.item66;

import java.util.concurrent.TimeUnit;

/**
 * Chapter 10
 * Item 66: Synchronize access to shared mutable data
 *
 *  Broken! - How long would you expect this program to run ?
 */
class StopThread {

  // although reads and writes to boolean are atomic operations,
  // that does not guarantee that a value written by one thread will be visible to another.
  private static boolean stopRequested;

  private static long iterations = 0;

  public static void main(String[] args) throws InterruptedException {

    Thread backgroundThread = new Thread(() -> {
      while (!stopRequested) {  // problem: there is no guarantee that backgroundThread
                                //          will see the change in the value of stopRequested.

        // uncommenting println changes program behavior
        // maybe because println uses synchronization inside
        // System.out.println(currentThread().getName() + ": i=" + i);

        iterations++;
      }
    });

    // without synchronization, compiler (JIT ?) can optimizes this code to the following:
    // if (!stopRequested)
    //   while (true)
    //     i++;

    // this optimization is known as `hoisting`

    backgroundThread.start();

    TimeUnit.MILLISECONDS.sleep(10);

    stopRequested = true;

    // the result is liveness failure: the program fails to make progress.

    System.out.println("iterations=" + iterations);
  }
}
