package jcp.book;

/**
 * Created by artur on 20.01.15.
 */
public class ThreadHelper {
    private static final int MS_IN_SECOND = 1000;

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * MS_IN_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
