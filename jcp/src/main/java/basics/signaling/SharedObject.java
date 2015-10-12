package basics.signaling;

/**
 * See {@link http://tutorials.jenkov.com/java-concurrency/thread-signaling.html}
 *
 */
class SharedObject {

	/**
	 * A simple way to send signals via shared objects.
	 * Thread A and B must have a reference to a shared MySignal instance for the signaling to work. 
	 */
	static class MySignal {
		protected boolean hasDataToProcess = false;

		public synchronized boolean hasDataToProcess() {
			return hasDataToProcess;
		}

		public synchronized void setHasDataToProcess(boolean hasData) {
			this.hasDataToProcess = hasData;
		}
	}	

	private class RunnerA implements Runnable {
		
		private final MySignal sharedSignal;

		public RunnerA(MySignal sharedSignal) {
			this.sharedSignal = sharedSignal;
		}

		@Override
		public void run() {
			
			// A.K.A. busy waiting
			while (!sharedSignal.hasDataToProcess()) {
				// It is not very efficient utilization of CPU, except if average waiting time is very small
				//  it would be smarter if the waiting thread could somehow sleep or become inactive until 
				// it receives the signal it is waiting for.
				// java.lang.Object defines three methods, wait(), notify(), and notifyAll(), 
				// to facilitate threads to become inactive while waiting for signals.
			}
		}
	}
}
