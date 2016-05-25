package chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Listing 6.4. Web Server Using a Thread Pool
 */
public class TaskExecutionWebServer {
  private static final int NUM_THREADS = 100;

  /**
   * Fixed-size thread pool with 100 threads
   */
  private static final Executor executor = Executors.newFixedThreadPool(NUM_THREADS);

  public static void main(String[] args) throws IOException {
    ServerSocket socket = new ServerSocket(8080);
    while (true) {
      final Socket connection = socket.accept();
      executor.execute(() -> handleRequest(connection));
    }
  }

  private static void handleRequest(Socket connection) {
    System.out.println("Processing request from " + connection.toString());
  }
}
