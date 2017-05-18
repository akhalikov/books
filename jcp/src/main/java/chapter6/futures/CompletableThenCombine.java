package chapter6.futures;

import static java.lang.Thread.currentThread;
import static toolkit.utils.ConsoleLogger.log;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * http://www.nurkiewicz.com/2013/05/java-8-definitive-guide-to.html
 *
 * `thenCombine` combines two independent futures when they are both done
 */
public class CompletableThenCombine {
  private static final Random RAND = new Random();

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    CompletableFuture<String> result1 = ask("ask-1", 5);
    CompletableFuture<String> result2 = ask("ask-2", 2);

    log("finally: " +
        result1
            .thenCombine(result2, CompletableThenCombine::callback) // callback will be executed after both task are complete
            .get()                                                  // question: in what thread will the callback be executed ? (in the same thread as ask-1)
    );
  }

  private static CompletableFuture<String> ask(String id, final int execTimeSec) {
    log(id);

    final CompletableFuture<String> future = new CompletableFuture<>();

    Thread t = new Thread(() -> {
      try {
        log(id + " sleep " + execTimeSec + " sec");
        TimeUnit.SECONDS.sleep(execTimeSec);

        int number = RAND.nextInt(200);
        log(id + " complete with result=" + number);

        future.complete(String.valueOf(number));

      } catch (InterruptedException e) {
        currentThread().interrupt();
        System.err.println(e.getMessage());
      }
    });
    t.start();

    return future;
  }

  private static int callback(String val1, String val2) {
    log("execute callback");
    return Integer.parseInt(val1) + Integer.parseInt(val2);
  }
}
