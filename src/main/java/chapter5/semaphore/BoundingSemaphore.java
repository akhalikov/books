package chapter5.semaphore;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Using Semaphore to bound a collection
 *
 * Using semaphore in such manner turns collection into a blocking
 * bounded collection. Bound plays role of maximum size of a collection.
 * Underlying Set implementation knows nothing about the bound.
 * If number of elements added (permits acquired) exceeds the bound,
 * acquire blocks until some element si removed (permit released).
 *
 * Created by artur on 25.02.15.
 */
public class BoundingSemaphore {
    static final int BOUND_NUM = 5;
    static final int EXTRA_NUM = 10;

    public static void main(String[] args) {
        BoundedHashSet<String> boundedHashSet = new BoundedHashSet<>(BOUND_NUM);
        try {
            for (int i = 1; i <= BOUND_NUM + EXTRA_NUM; i++) {
                boundedHashSet.add("test_" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class BoundedHashSet<T> {
        private final Set<T> set;
        private final Semaphore sem;

        public BoundedHashSet(int bound) {
            this.set = Collections.synchronizedSet(new HashSet<T>());
            this.sem = new Semaphore(bound);
        }

        public boolean add(T o) throws InterruptedException {
            sem.acquire();
            boolean wasAdded = false;
            try {
                wasAdded = set.add(o);
                return wasAdded;
            } finally {
                if (!wasAdded)
                    sem.release();
            }
        }

        public boolean remove(Object o) {
            boolean wasRemoved = set.remove(o);
            if (wasRemoved)
                sem.release();
            return wasRemoved;
        }
    }
}
