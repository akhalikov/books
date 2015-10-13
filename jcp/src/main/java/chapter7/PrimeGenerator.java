package chapter7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * One of the cooperative mechanisms is setting a "cancellation requested" flag that the task checks periodically;
 * if it finds the flag set, the task terminates early.
 *
 * PrimeGenerator in Listing 7.1, which enumerates prime numbers until it is cancelled, illustrates this technique.
 * The cancel method sets the cancelled flag, and the main loop polls this flag
 * before searching for the next prime number. (For this to work reliably, cancelled must be volatile.)
 */
public class PrimeGenerator implements Runnable {

    private final List<BigInteger> primes = new ArrayList();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList(primes);
    }

    /**
     * Listing 7.2 shows a sample use of this class that lets the prime generator run for one second before cancelling it.
     * The generator won't necessarily stop after exactly one second, since there may be some delay between the time that
     * cancellation is requested and the time that the run loop next checks for cancellation.
     *
     * The cancel method is called from a finally block to ensure that the prime generator is cancelled even if the call
     * to sleep is interrupted. If cancel were not called, the primeͲseeking thread would run forever,
     * consuming CPU cycles and preventing the JVM from exiting.
     */
    public static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            Thread.sleep(1_000);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }

    public static void main(String[] args) throws Exception {
        List<BigInteger> primes = aSecondOfPrimes();
        for (BigInteger p: primes)
            System.out.println(p);
    }
}
