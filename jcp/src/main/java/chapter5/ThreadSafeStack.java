package chapter5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread-safe implementation of stack data structure
 *
 * Add blocking conditions
 *
 * @author ahalikov
 */
public class ThreadSafeStack<E> {

    private Object[] items;
    private int capacity;
    private int size;

    private final ReentrantLock lock;

    ThreadSafeStack(int capacity) {
        this.capacity = capacity;
        this.items = new Object[capacity];
        lock = new ReentrantLock(true);
    }

    boolean push(E item) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (size + 1 <= capacity) {
                items[size++] = item;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    E pop() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (size == 0) {
                return null;
            } else {
                E item = (E) items[size-1];
                items[--size] = null;
                return item;
            }
        } finally {
            lock.unlock();
        }
    }
}
