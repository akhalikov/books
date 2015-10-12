package basics.signaling;

/**
 * The code shows how to deal with "spurious wakeups" problem. 
 *
 * For inexplicable reasons it is possible for threads to wake up even if notify() and notifyAll() has not been called. 
 * This is known as spurious wakeups. Wakeups without any reason.
 */
public class MyWaitNotify3 {

    private final Object monitorObject = new Object();
    private boolean wasSignalled = false;

    public void doWait() {
        synchronized(monitorObject) {

            // To guard against spurious wakeups the signal member variable 
            // is checked inside a while loop instead of inside an if-statement.
            // Such a while loop is also called a spin lock.
            while (!wasSignalled) {
                try {                  
                    monitorObject.wait();
                } catch (InterruptedException e) {
                    // ...            
                }
            }
            // Clear signal and continue running
            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized(monitorObject) {
            wasSignalled = true;
            monitorObject.notify();
        }
    }
}
