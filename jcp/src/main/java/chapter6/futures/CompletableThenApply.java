package chapter6.futures;

import static chapter6.futures.AskService.getRandomNumber;
import static com.ahalikov.toolkit.threads.ThreadHelper.clog;

import java.util.concurrent.CompletableFuture;

/**
 * http://www.nurkiewicz.com/2013/05/java-8-definitive-guide-to.html
 */
class CompletableThenApply {

  public static void main(String[] args) throws Exception {
    clog("main");

    CompletableFuture<Integer> future = getRandomNumber("random number", 5)
            .thenApply(CompletableThenApply::callback); // apply will be executed in the same thread as `getRandomNumber`

    clog("result=" + future.get());
  }

  private static int callback(int value) {
    clog("callback");
    return value + 42;
  }
}
