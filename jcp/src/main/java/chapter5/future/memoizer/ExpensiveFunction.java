package chapter5.future.memoizer;

import java.math.BigInteger;

/**
 * @author ahalikov
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {

    public BigInteger compute(String arg) {
        // after deep thought...
        return new BigInteger(arg);
    }
}
