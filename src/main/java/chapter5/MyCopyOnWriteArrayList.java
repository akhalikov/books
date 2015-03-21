package chapter5;

/**
 * Simple implementation of CopyOnWriteArrayList
 *    
 * JavaDoc definition: A thread-safe variant of ArrayList in which 
 * all mutative operations (add, set, and so on) are implemented 
 * by making a fresh copy of the underlying array.
 */
public class MyCopyOnWriteArrayList<T> {
    private volatile Object[] array = new Object[0];

    /**
     * Appends element to the end of the list
     */ 
    public void add(T item) {
        final int length = array.length;
        final Object[] newArray = new Object[length + 1];

        System.arraycopy(array, 0, newArray, 0, length);
        newArray[length] = item;
    }

    public void add(int index, T item) {
        final int length = array.length;
        final Object[] newArray = new Object[length + 1];
        
        // 0 1 2 3 4 5
        // 3 1 9 0 2 4 

        System.arraycopy(array, 0, newArray, 0, index+1);

    }

    public void remove(int index) {

    }

    public T get(int index) {
        return (T) array[index];
    }

    public int size() {
        return array.length;
    }
}