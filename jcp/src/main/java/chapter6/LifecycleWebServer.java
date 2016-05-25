package chapter6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/**
 * Listing 6.8. Web Server with Shutdown Support
 */
public class LifecycleWebServer {
  private static final int NUM_THREADS = 100;
  private final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

  public void start() throws IOException {
    ServerSocket serverSocket = new ServerSocket(8080);
    while (!executorService.isShutdown()) {
      try {
        final Socket socket = serverSocket.accept();
        executorService.execute(() -> handleRequest(socket));
      } catch (RejectedExecutionException e) {
        if (!executorService.isShutdown()) {
          log("Task submission rejected", e);
        }
      }
    }
  }

  private void handleRequest(Socket socket) {
    Request request = readRequest(socket);
    if (isShutdownRequest(request)) {
      stop();
    } else {
      dispatchRequest();
    }
  }

  private Request readRequest(Socket socket) {
    return new Request(socket);
  }

  private boolean isShutdownRequest(Request request) {
    return "stop".equalsIgnoreCase(request.getRequestURI());
  }

  private void log(String message, Exception e) {
    System.out.println(message);
    e.printStackTrace();
  }

  private void stop() {
    // Stop server here
  }

  private void dispatchRequest() {
    // Processing request here
  }

  static class Request {
    private Socket socket;

    Request(Socket socket) {
      this.socket = socket;
    }

    String getRequestURI() {
      return "";
    }
  }
}
