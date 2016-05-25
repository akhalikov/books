package chapter6;

import toolkit.threads.ThreadHelper;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Listing 6.9. Class Illustrating Confusing Timer Behavior
 */
public class OutOfTime {
  public static void main(String[] args) {
    Timer timer = new Timer();
    timer.schedule(new ThrowTask(), 1);

    ThreadHelper.sleepSeconds(1);

    timer.schedule(new ThrowTask(), 1);

    ThreadHelper.sleepSeconds(5);
  }

  static class ThrowTask extends TimerTask {
    @Override
    public void run() {

      // The Timer thread doesn't catch the exception, so an unchecked exception
      // thrown from a TimerTask terminates the timer thread.

      // Timer also doesn't resurrect the thread in this situation;
      // instead, it erroneously assumes the entire Timer was cancelled.

      throw new RuntimeException("Exception inside TimerTask");
    }
  }
}
