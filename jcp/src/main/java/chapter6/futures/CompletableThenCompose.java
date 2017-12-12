package chapter6.futures;

import static chapter6.futures.AskService.addRandom;
import static chapter6.futures.AskService.getRandomNumber;
import static com.ahalikov.toolkit.threads.ThreadHelper.clog;

import java.util.concurrent.CompletableFuture;

/**
 * http://www.nurkiewicz.com/2013/05/java-8-definitive-guide-to.html
 *
 * `thenCompose` is equivalent to Optional.flatMap and Stream.flatMap
 */
class CompletableThenCompose {

  public static void main(String[] args) throws Exception {
    CompletableFuture<Integer> future = getRandomNumber("#1", 5);

    withThenCompose(future);

    //withThenApply(future);
  }

  private static void withThenCompose(CompletableFuture<Integer> future) throws Exception {
    // more concise with thenCompose:
    CompletableFuture<Integer> future2 = future.thenCompose(v -> addRandom(v, "#2", 2));

    System.out.println("result 2:" + future2.thenApply(CompletableThenCompose::callback).get());
  }

  private static void withThenApply(CompletableFuture<Integer> future) throws Exception {
    // problem: nested CompletableFuture's
    CompletableFuture<CompletableFuture<Integer>> future2 = future.thenApply(v -> addRandom(v, "#2", 2));

    System.out.println("result 2:" + future2.get().thenApply(CompletableThenCompose::callback).get());
  }

  private static int callback(int v) {
    clog("callback");
    return v + 1;
  }
}
