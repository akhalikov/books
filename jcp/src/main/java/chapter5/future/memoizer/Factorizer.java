package chapter5.future.memoizer;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * Listing 5.20. Factorizing Servlet that Caches Results Using Memorizer.
 */
class Factorizer extends GenericServlet implements Servlet {

    private final Computable<BigInteger, BigInteger[]> c =
            new Computable<BigInteger, BigInteger[]>() {
                public BigInteger[] compute(BigInteger arg) {
                    return factor(arg);
                }
            };

    private final Computable<BigInteger, BigInteger[]> cache = new Memorizer(c);

    @Override
    public void service(ServletRequest req, ServletResponse resp) {
        try {
            BigInteger i = extractFromRequest(req);
            encodeIntoResponse(resp, cache.compute(i));
        } catch (InterruptedException e) {
            encodeError(resp, "factorization interrupted");
        }
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {}
    void encodeError(ServletResponse resp, String errorString) {}

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("42");
    }
}
