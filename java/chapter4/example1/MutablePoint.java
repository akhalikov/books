package chapter4.example1;

/**
 * Mutable Point class
 * 
 * Created by Artur on 28-Dec-14.
 */
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0; y = 0;
    }

    public MutablePoint(MutablePoint point) {
        x = point.x;
        y = point.y;
    }
}
