package chapter7;

import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Listing 7.16. Logging Service that Uses an ExecutorService.
 */
class LogService2 {
  private static final int SHUTDOWN_TIMEOUT_MS = 200;
  private final ExecutorService executor = Executors.newSingleThreadExecutor();
  private final PrintWriter writer;

  LogService2(PrintWriter writer) {
    this.writer = writer;
  }

  void start() {
  }

  void stop() throws InterruptedException {
    try {
      executor.shutdown();
      executor.awaitTermination(SHUTDOWN_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    } finally {
      writer.close();
    }
  }

  void log(String msg) {
    try {
      executor.execute(new WriteTask(msg));
    } catch (RejectedExecutionException ignored) {}
  }

  private static class WriteTask implements Runnable {
    private String message;

    public WriteTask(String message) {
      this.message = message;
    }

    @Override
    public void run() {
      // do the writing stuff
    }
  }
}
