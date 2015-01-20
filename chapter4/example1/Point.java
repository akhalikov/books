package chapter4.example1;

/**
 * Immutable Point
 * 
 * Created by Artur on 28-Dec-14.
 */
public class Point {
    
    // Values are final (immutable) so they can be freely shared and published
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
