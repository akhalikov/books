package chapter7;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Listing 7.15. Adding Reliable Cancellation to LogWriter.
 */
class LogService1 {
  private static final int LOG_QUEUE_CAPACITY = 100;

  private final BlockingQueue<String> queue;
  private final LoggerThread loggerThread;
  private final PrintWriter writer;

  private boolean isShutdown;
  private int reservations;

  LogService1(PrintWriter writer) {
    this.writer = writer;
    this.queue = new LinkedBlockingQueue<>(LOG_QUEUE_CAPACITY);
    this.loggerThread = new LoggerThread(writer);
  }

  void start() {
    loggerThread.start();
  }

  void stop() {
    synchronized (this) {
      isShutdown = true;
    }
    loggerThread.interrupt();
  }

  void log(String msg) throws InterruptedException {
    synchronized (this) {
      if (isShutdown) {
        throw new IllegalStateException("Logger is shutdown");
      }
      reservations++;
    }
    queue.put(msg);
  }

  private class LoggerThread extends Thread {
    private final PrintWriter writer;

    LoggerThread(PrintWriter writer) {
      this.writer = writer;
    }

    @Override
    public void run() {
      try {
        while (true) {
          try {
            synchronized (this) {
              if (isShutdown && reservations == 0)
                break;
            }
            String msg = queue.take();
            synchronized (this) {
              --reservations;
            }
            writer.println(msg);
          } catch (InterruptedException e) {

            // retry

          }
        }
      } finally {
        writer.close();
      }
    }
  }
}
