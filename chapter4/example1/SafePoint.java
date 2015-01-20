package chapter4.example1;

/**
 * Created by artur on 03.01.15.
 */
public class SafePoint {
    private int x, y;

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public SafePoint(int[] arr) {
        this.x = arr[0];
        this.y = arr[1];
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public synchronized int[] get() {
        return new int[] {x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
