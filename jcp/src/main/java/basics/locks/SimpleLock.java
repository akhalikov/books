package basics.locks;

/**
 * Simple lock implementation
 * Not-reentrant, not-fair
 *
 * {@see http://tutorials.jenkov.com/java-concurrency/locks.html}
 */
class SimpleLock {

	private boolean isLocked = false;

	public synchronized void lock() {
		while (isLocked) {
			try {
				wait();
			} catch (InterruptedException e) {
				// ...
			}
		}
		isLocked = true;
	}

	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}
