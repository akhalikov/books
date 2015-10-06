package chapter5.queue.implementations;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Blocking queue implementation
 *
 * @author ahalikov
 */
public class MyArrayBlockingQueue<E> {

    private int capacity;
    private final Object[] items;

    final ReentrantLock lock;

    public MyArrayBlockingQueue(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity <= 0");
        this.capacity = capacity;
        this.items = new Object[capacity];
        this.lock = new ReentrantLock(true);
    }
}
