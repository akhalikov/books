package chapter5.future.memoizer;

import annotations.GuardedBy;

import java.util.HashMap;
import java.util.Map;

/**
 * Memorizer example v.1
 *
 * Listing 5.16. Initial Cache Attempt Using HashMap and Synchronization
 *
 * Memorizer1 in Listing 5.16 shows a first attempt: using a HashMap to store the results of previous computations.
 * The compute method first checks whether the desired result is already cached, and returns the pre-computed value
 * if it is. Otherwise, the result is computed and cached in the HashMap before returning.
 *
 * HashMap is not thread-safe, so to ensure that two threads do not access the HashMap at the same time,
 * Memorizer1 takes the conservative approach of synchronizing the entire compute method.
 *
 * This ensures thread safety but has an obvious scalability problem: only one thread at a time can execute
 * compute at all. If another thread is busy computing a result, other threads calling compute may be blocked
 * for a long time. If multiple threads are queued up waiting to compute values not already computed,
 * compute may actually take longer than it would have without Memorization.
 *
 */
class Memorizer1<A, V> implements Computable<A, V> {

    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap();

    private final Computable<A, V> c;

    Memorizer1(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}