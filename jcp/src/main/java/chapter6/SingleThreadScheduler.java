package chapter6;

import static java.lang.Thread.currentThread;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduler {

  private static int counter = 0;

  public static void main(String[] args) throws Exception {
    Executors
        .newSingleThreadScheduledExecutor()
        .scheduleAtFixedRate(() -> {

          if (++counter > 2) {
            System.err.println(currentThread() + " ups, something bad happened");
            throw new RuntimeException(); // problem: executor will not schedule subsequent tasks after exception in task
                                          // the most easy way to resolve this problem is to wrap executions into try-catch block
          }

          System.out.println(currentThread() + ": ok " + counter);

        }, 0, 2, TimeUnit.SECONDS);
  }
}
