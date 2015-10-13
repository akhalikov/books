package basics.locks;

/**
 * Simple lock implementation
 * Not-reentrant, not-fair
 *
 * {@see http://tutorials.jenkov.com/java-concurrency/locks.html}
 */
class SimpleLock implements Lock {

	private boolean isLocked = false;

	public synchronized void lock() {
		while (isLocked) {
			try {
				wait();
			} catch (InterruptedException e) {
				// Interrupted exceptions should not be swallowed
				// At least, restore the interrupted status like below:
				Thread.currentThread().interrupt();
			}
		}
		isLocked = true;
	}

	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}
