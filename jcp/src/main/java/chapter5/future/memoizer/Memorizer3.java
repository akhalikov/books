package chapter5.future.memoizer;

import common.LaunderThrowable;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Memorizer example v.3
 *
 * Listing 5.18. Memorizing Wrapper Using FutureTask.
 *
 * Memorizer3 redefines the backing Map for the value cache as a ConcurrentHashMap<A,Future<V>>
 * instead of a ConcurrentHashMap<A,V>. Memorizer3 first checks to see if the appropriate calculation
 * has been started (as opposed to finished, as in Memorizer2). If not, it creates a FutureTask,
 * registers it in the Map, and starts the computation; otherwise it waits for the result of the existing computation.
 * The result might be available immediately or might be in the process of being computed,
 * but this is transparent to the caller of Future.get.
 *
 * The Memorizer3 implementation is almost perfect: it exhibits very good concurrency
 * (mostly derived from the excellent concurrency of ConcurrentHashMap), the result is returned efficiently
 * if it is already known, and if the computation is in progress by another thread, newly arriving threads
 * wait patiently for the result. It has only one defect there is still a small window of vulnerability
 * in which two threads might compute the same value. This window is far smaller than in Memorizer2,
 * but because the if block in compute is still a non-atomic check-then-act sequence,
 * it is possible for two threads to call compute with the same value at roughly the same time,
 * both see that the cache does not contain the desired value, and both start the computation.
 *
 * Memorizer3 is vulnerable to this problem because a compound action (put-if-absent) is performed
 * on the backing map that cannot be made atomic using locking.
 */
class Memorizer3<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache  = new ConcurrentHashMap();

    private final Computable<A, V> c;

    Memorizer3(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                public V call() throws InterruptedException {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run(); // call to c.compute happens here
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw LaunderThrowable.launder(e.getCause());
        }
    }
}
