package basics;

import com.ahalikov.toolkit.threads.*;

/**
 * Example demonstrates how a thread can be interrupted
 *
 * @author ahalikov
 */
class ThreadStop {

  public static void main(String[] args) {
    ThreadHelper.clog("started");

    //interruptedExceptionExample();
    interruptedStatusExample(true);

    ThreadHelper.clog("finished");
  }

  static void interruptedExceptionExample() {
    Thread thread = new Thread(
        () -> {
          ThreadHelper.clog("started");
          try {
            Thread.sleep(1000 * 10);

            ThreadHelper.clog("finished");
          } catch (InterruptedException ie) {
            ThreadHelper.clog("interrupted, isInterrupted="
                + Thread.currentThread().isInterrupted());
          }
        }
    );

    thread.start();

    ThreadHelper.sleepSeconds(2);

    thread.interrupt();
  }

  static void interruptedStatusExample(boolean clearInterruptedStatus) {
    Thread thread = new Thread(
        () -> {
          ThreadHelper.clog("started");
          while (true) {
            if (clearInterruptedStatus) {
              if (Thread.interrupted()) {
                ThreadHelper.clog("interrupted, isInterrupted="
                    + Thread.currentThread().isInterrupted() + " => cleared");
              }
            } else {
              if (Thread.currentThread().isInterrupted()) {
                ThreadHelper.clog("interrupted, isInterrupted="
                    + Thread.currentThread().isInterrupted());
                return;
              }
            }
          }
        }
    );

    thread.start();

    ThreadHelper.sleepSeconds(2);

    thread.interrupt();
  }
}
