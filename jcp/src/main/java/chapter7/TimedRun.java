package chapter7;

import common.LaunderThrowable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Listing 7.10. Cancelling a Task Using Future.
 */
public class TimedRun {

  private static final ExecutorService taskExecutor = Executors.newSingleThreadExecutor();

  public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
    Future<?> task = taskExecutor.submit(r);
    try {
      task.get(timeout, unit);
    } catch (TimeoutException e) {
      // task will be cancelled below
    } catch (ExecutionException e) {
      // exception thrown in task; rethrow
      throw LaunderThrowable.launder(e.getCause());
    } finally {
      // Harmless, if task us already completed
      task.cancel(true);
    }
  }
}
