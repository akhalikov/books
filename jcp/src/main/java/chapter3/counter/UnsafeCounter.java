package chapter3.counter;

/**
 * Created by artur on 04.01.15.
 */
public class UnsafeCounter implements Counter {

    private int value = 0;

    @Override
    public void increment() {
        if (MAX_VALUE == value) {
            throw new IllegalStateException("Counter value exceeded its max");
        }
        ++value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
