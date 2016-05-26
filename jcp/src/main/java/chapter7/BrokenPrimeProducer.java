package chapter7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Listing 7.3. Unreliable Cancellation that can Leave Producers Stuck in a Blocking Operation.
 * Don't Do this!
 *
 * BrokenPrimeProducer illustrates how custom cancellation mechanisms do not always interact well
 * with blocking library methods. If you code your tasks to be responsive to interruption, you can use interruption
 * as your cancellation mechanism and take advantage of the interruption support provided by many library classes.
 *
 * !!! Interruption is usually the most sensible way to implement cancellation.
 */
class BrokenPrimeProducer {

  static class PrimeProducer implements Runnable {
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    PrimeProducer(BlockingQueue<BigInteger> queue) {
      this.queue = queue;
    }

    public void run() {
      try {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
          queue.put(p = p.nextProbablePrime());
        }
      } catch (InterruptedException consumed) {
        // ignored
      }
    }

    public void cancel() {
      cancelled = true;
    }
  }

  static class PrimeConsumer {
    void consumePrimes() throws InterruptedException {
      BlockingQueue<BigInteger> primes = new ArrayBlockingQueue(10);
      PrimeProducer producer = new PrimeProducer(primes);
      new Thread(producer).start();
      try {
        while (needMorePrimes())
          consume(primes.take());
      } finally {
        producer.cancel();
      }
    }

    boolean needMorePrimes() {
      return true;
    }

    void consume(BigInteger prime) {
      System.out.println("Next prime: " + prime);
    }
  }

  public static void main(String[] args) throws Exception {
    new PrimeConsumer().consumePrimes();
  }
}

