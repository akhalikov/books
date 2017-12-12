package chapter6.futures;

import static com.ahalikov.toolkit.threads.ThreadHelper.clog;
import static java.lang.Thread.currentThread;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class AskService {
  private static final Random RAND = new Random();

  static CompletableFuture<Integer> getRandomNumber(String id, int execTimeSec) {
    clog(id);

    final CompletableFuture<Integer> future = new CompletableFuture<>();

    Thread t = new Thread(() -> {
      try {
        clog(id + " sleep " + execTimeSec + " sec");
        TimeUnit.SECONDS.sleep(execTimeSec);

        int number = RAND.nextInt(200);
        clog(id + " generated random=" + number);

        future.complete(number);

      } catch (InterruptedException e) {
        currentThread().interrupt();
        System.err.println(e.getMessage());
      }
    });
    t.start();

    return future;
  }

  static CompletableFuture<Integer> addRandom(int value, String id, int execTimeSec) {
    clog(id);

    final CompletableFuture<Integer> future = new CompletableFuture<>();

    Thread t = new Thread(() -> {
      try {
        clog(id + " sleep " + execTimeSec + " sec");
        TimeUnit.SECONDS.sleep(execTimeSec);

        int randomNumber = RAND.nextInt(200);
        clog(id + " generated random=" + randomNumber);

        future.complete(value + randomNumber);

      } catch (InterruptedException e) {
        currentThread().interrupt();
        System.err.println(e.getMessage());
      }
    });
    t.start();

    return future;
  }
}
