package chapter7;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class LogWriter {
  private static final int LOG_QUEUE_CAPACITY = 100;

  private final BlockingQueue<String> queue;
  private final LoggerThread logger;

  LogWriter(PrintWriter writer) {
    this.queue = new LinkedBlockingQueue<>(LOG_QUEUE_CAPACITY);
    this.logger = new LoggerThread(writer);
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
          writer.println(queue.take());
        }
      } catch (InterruptedException ignored)  {

      } finally {
        writer.close();
      }
    }
  }
}
