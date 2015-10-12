package basics.signaling;

/**
 * {@See http://tutorials.jenkov.com/java-concurrency/thread-signaling.html}
 */
public class MyWaitNotify {

    private final Object monitorObject = new Object();

    public void doWait() {
        synchronized(monitorObject) {
            try {
                // Once a thread calls wait() it releases the lock it holds on the monitor object. 
                // This allows other threads to call wait() or notify() too, 
                // since these methods must be called from inside a synchronized block.

                // Once a thread is awakened it cannot exit the wait() call
                // until the thread calling notify() has left its synchronized block. 
                // In other words: The awakened thread must reobtain the lock on the monitor object 
                // before it can exit the wait() call, because the wait call is nested inside a synchronized block.
                
                monitorObject.wait();
                
            } catch (InterruptedException e) {
                // ...            
            }
        }
    }

    public void doNotify() {
        synchronized(monitorObject) {
            // If multiple threads are awakened using notifyAll(),
            // only one awakened thread at a time can exit the wait() method, 
            // since each thread must obtain the lock on the monitor object in turn before exiting wait().
            
            monitorObject.notify();
        }
    }
}
