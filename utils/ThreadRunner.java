package utils;

/**
 * Created by artur on 04.01.15.
 */
public class ThreadRunner {

    private int numberOfThreads = 0;

    public ThreadRunner(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public void start(Runnable r) {
        for (int i = 1; i <= numberOfThreads; i++) {
            new Thread(r, "Thread-" + i).start();
        }
    }
}
