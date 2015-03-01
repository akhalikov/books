package utils;

import java.util.Random;

/**
 * Created by artur on 20.01.15.
 */
public class ThreadHelper {
    private static final int MS_IN_SECOND = 1000;
    private static final Random RANDOM = new Random();

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * MS_IN_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public static void sleepRandomSeconds(int bound) {
        sleepSeconds(RANDOM.nextInt(bound));
    }
}
