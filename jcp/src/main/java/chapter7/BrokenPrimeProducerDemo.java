package chapter7;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Listing 7.3. Unreliable Cancellation that can Leave Producers Stuck in a Blocking Operation.
 * Don't Do this!
 *
 * @author ahalikov
 */
class BrokenPrimeProducerDemo {

    static class BrokenPrimeProducer implements Runnable {
        private final BlockingQueue<BigInteger> queue;
        private volatile boolean cancelled = false;

        BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                BigInteger p = BigInteger.ONE;
                while (!cancelled) {
                    queue.put(p = p.nextProbablePrime());
                }
            } catch (InterruptedException consumed) { }
        }

        public void cancel() {
            cancelled = true;
        }
    }

    static class BrokenPrimeConsumer {

        void consumePrimes() throws InterruptedException {
            BlockingQueue<BigInteger> primes = new ArrayBlockingQueue(10);
            BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
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
        new BrokenPrimeConsumer().consumePrimes();
    }
}

