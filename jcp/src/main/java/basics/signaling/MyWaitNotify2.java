package basics.signaling;

/**
 * To avoid losing signals monitor object should be stored inside the signal class.
 * 
 * Notice how the doNotify() method now sets the wasSignalled variable to true before calling notify(). 
 * Also, notice how the doWait() method now checks the wasSignalled variable before calling wait(). 
 * In fact it only calls wait() if no signal was received in between the previous doWait() call and this.
 */
public class MyWaitNotify2 {

    private final Object monitorObject = new Object();
    private boolean wasSignalled = false;

    public void doWait() {
        synchronized(monitorObject) {
            if (!wasSignalled) {
                try {
                    monitorObject.wait();
                } catch (InterruptedException e) {
                    // ...            
                }
            }
            // Clear signal and continue running.
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
