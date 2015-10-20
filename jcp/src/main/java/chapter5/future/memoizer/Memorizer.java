package chapter5.future.memoizer;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Listing 5.19. Final Implementation of Memorizer.
 *
 * Memorizer in Listing 5.19 takes advantage of the atomic putIfAbsent method of ConcurrentMap,
 * closing the window of vulnerability in Memorizer3.
 *
 * Caching a Future instead of a value creates the possibility of cache pollution:
 *      if a computation is cancelled or fails, future attempts to compute the result will also indicate
 *      cancellation or failure. To avoid this, Memorizer removes the Future from the cache if it detects
 *      that the computation was cancelled;
 *
 *  it might also be desirable to remove the Future upon detecting a RuntimeException if the computation
 *  might succeed on a future attempt. Memorizer also does not address cache expiration,
 *  but this could be accomplished by using a subclass of FutureTask that associates an expiration time with
 *  each result and periodically scanning the cache for expired entries. (Similarly, it does not address
 *  cache eviction, where old entries are removed to make room for new ones so that the cache does not consume
 *  too much memory.)
 *
 *  With our concurrent cache implementation complete, we can now add real caching to the factorizing servlet
 *  from Chapter 2, as promised. Factorizer in Listing 5.20 uses Memorizer to cache previously computed values
 *  efficiently and scalably.
 *
 */
class Memorizer<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memorizer(Computable<A, V> c) {
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
