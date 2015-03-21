package chapter5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Simple implementation of CopyOnWriteArrayList
 *    
 * JavaDoc definition: A thread-safe variant of ArrayList in which 
 * all mutative operations (add, set, and so on) are implemented 
 * by making a fresh copy of the underlying array.
 */
public class MyCopyOnWriteArrayList<E> {
    private volatile Object[] array = new Object[0];
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * Appends element to the end of the list
     */ 
    public void add(E item) {
        final int len = array.length;
        final Object[] newArray = new Object[len + 1];
        System.arraycopy(array, 0, newArray, 0, len);
        newArray[len] = item;
        array = newArray;
    }

    public void add(int index, E item) {
        final int length = array.length;
        final Object[] newArray = new Object[length + 1];
        
        // 0 1 2 3 4 5
        // 3 1 9 0 2 4 

        System.arraycopy(array, 0, newArray, 0, index+1);

    }

    public void remove(int index) {

    }

    public E get(int index) {
        return (E) array[index];
    }

    public int size() {
        return array.length;
    }

    public Object[] toArray() {
        return array;
    }
}