package chapter5;

/**
 * Simple implementation of CopyOnWriteArrayList
 *
 * Created by artur on 20.03.15.
 */
public class MyCopyOnWriteArrayList<T> {
    private volatile Object[] array = new Object[0];

    public static void main(String[] args) {

    }

    public void add(int index, T item) {

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
