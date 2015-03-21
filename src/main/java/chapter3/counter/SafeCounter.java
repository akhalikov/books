package chapter3.counter;

/**
 * Created by artur on 04.01.15.
 */
public class SafeCounter implements Counter {

    private int value = 0;

    @Override
    public synchronized void increment() {
        if (MAX_VALUE == value) {
            throw new IllegalStateException("Counter value exceeded its max");
        }
        ++value;
    }

    @Override
    public synchronized int getValue() {
        return value;
    }
}
