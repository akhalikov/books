package basics.locks;

/**
 * See {@link http://tutorials.jenkov.com/java-concurrency/locks.html}
 *
 * Simple lock implementation
 * Not-reentrant, not-fair
 */
class SimpleLock {

	private boolean isLocked = false;

  	public synchronized void lock() throws InterruptedException {
    	while (isLocked) {
      		wait();
    	}
    	isLocked = true;
  	}

  	public synchronized void unlock() {
    	isLocked = false;
    	notify();
  	}
}
