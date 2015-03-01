package chapter5.future;

import utils.ThreadHelper;
import utils.ThreadRunner;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Concurrent Cache Example
 * Created by artur on 27.02.15.
 */
public class MemoizerExample {

    public static void main(String[] args) {

    }

    interface Computable<A, V> {
        V compute(A arg) throws InterruptedException;
    }

    class ExpensiveFunction implements Computable<String, BigInteger> {
        @Override
        public BigInteger compute(String arg) throws InterruptedException {
            ThreadHelper.sleepRandomSeconds(100);
            return new BigInteger(arg);
        }
    }

    class Memoizer<A, V> implements Computable<A, V> {
        private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
        private final Computable<A, V> c;

        public Memoizer(Computable<A, V> c) {
            this.c = c;
        }

        public V compute(final A arg) throws InterruptedException {
            while (true) {
                Future<V> f = cache.get(arg);
                if (f == null) {
                    FutureTask<V> ft = new FutureTask<V>(() -> c.compute(arg));
                    f = cache.putIfAbsent(arg, ft);
                    if (f == null) {
                        f = ft;
                        ft.run();
                    }
                }
                try {
                    return f.get();
                } catch (CancellationException e) {
                    cache.remove(arg, f);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e.getCause());
                }
            }
        }
    }
}
