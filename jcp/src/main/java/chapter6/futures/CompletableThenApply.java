package chapter6.futures;

import static java.lang.Thread.currentThread;
import static toolkit.utils.ConsoleLogger.log;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * http://www.nurkiewicz.com/2013/05/java-8-definitive-guide-to.html
 */
public class CompletableThenApply {

  public static void main(String[] args) throws Exception {
    log("main");
    CompletableFuture<Integer> future = ask()
            .thenApply(CompletableThenApply::callback); // apply will be executed in `execution thread` after completion

    log("result=" + future.get());
  }

  private static CompletableFuture<String> ask() throws InterruptedException {
    log("ask");
    final CompletableFuture<String> future = new CompletableFuture<>();

    Thread t = new Thread(() -> { // future execution thread
      try {
        final int execTimeSec = 5;

        log("ask sleep " + execTimeSec + " sec");
        TimeUnit.SECONDS.sleep(execTimeSec);

        log("ask complete");
        future.complete("222");

      } catch (InterruptedException e) {
        currentThread().interrupt();
        System.err.println(e.getMessage());
      }
    });
    t.setName("execution thread");
    t.start();

    return future;
  }

  private static int callback(String value) {
    log("callback");
    return Integer.parseInt(value) + 3;
  }
}
