package chapter6.futures;

import static chapter6.futures.AskService.getRandomNumber;
import static toolkit.utils.ConsoleLogger.log;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * http://www.nurkiewicz.com/2013/05/java-8-definitive-guide-to.html
 *
 * `thenCombine` combines two independent futures when they are both done
 */
class CompletableThenCombine {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    CompletableFuture<Integer> future1 = getRandomNumber("#1", 5);
    CompletableFuture<Integer> future2 = getRandomNumber("#2", 2);

    log("finally: " +
        future1
            .thenCombine(future2, CompletableThenCombine::callback) // callback will be executed after both task are complete
            .get()                                                  // question: in what thread will the callback be executed ? (in the same thread as getRandomNumber-1)
    );
  }

  private static int callback(int a, int b) {
    log("execute callback");
    return a + b;
  }
}
