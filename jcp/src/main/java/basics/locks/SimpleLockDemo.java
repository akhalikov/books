package basics.locks;

/**
 * Example of using simple lock
 */
public class SimpleLockDemo {

    static class Counter {
        private Lock lock = new SimpleLock();
        private int count = 0;

        public int increment() {
            lock.lock();
            int newCount = ++count;
            lock.unlock();
            return newCount;
        }
    }

    private static Counter counter = new Counter();

    public static void main(String[] args) {
        Thread[] threads = new Thread[2];
        for (int i = 0; i < threads.length; i++) {
            (threads[i] = new Thread(() -> {
                int val;
                do {
                    val = counter.increment();
                } while (val <= 1_000_000);
            })).start();
        }
    }
}
