package chapter6.futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * http://www.nurkiewicz.com/2013/05/java-8-definitive-guide-to.html
 */
public class CompletableBlockForever {

  public static void main(String[] args) throws Exception {

    // we are blocking forever here, why ?
    // because future is never being completed
    // blockingAsk().get();

    // now it's ok - because we are completing our future in ask()
    System.out.println(ask().get());
  }

  private static CompletableFuture<String> blockingAsk() {
    System.out.println("blocking ask: start");
    final CompletableFuture<String> future = new CompletableFuture<>();

    return future;
  }

  private static CompletableFuture<String> ask() throws InterruptedException {
    System.out.println("ask: start");

    final CompletableFuture<String> future = new CompletableFuture<>();

    System.out.println("ask: sleep for 2 sec");
    TimeUnit.SECONDS.sleep(2);

    System.out.println("ask: complete with 42");
    future.complete("42");

    return future;
  }
}
