package chapter3.counter;

/**
 * Mutable singleton counter
 *
 * Created by artur on 04.01.15.
 */
public class UnsafeSingletonCounter extends UnsafeCounter {

    private static UnsafeSingletonCounter ourInstance = new UnsafeSingletonCounter();

    public static UnsafeSingletonCounter getInstance() {
        return ourInstance;
    }

    private UnsafeSingletonCounter() {
    }
}
