package basics.locks;

/**
 * Basic use case for {@link ReentrantLock}
 */
public class ReentrantLockDemo {

    private final Lock lock = new ReentrantLock();

    public void outer() {
        lock.lock();
        inner();
        lock.unlock();
    }

    public synchronized void inner(){
        lock.lock();
        // do something
        lock.unlock();
    }

    public static void main(String[] args) {
        // ...
    }
}
