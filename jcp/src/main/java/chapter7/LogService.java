package chapter7;

/**
 * Listing 7.26. Registering a Shutdown Hook to Stop the Logging Service
 */
class LogService {
  /**
   * Start logging service
   */
  void start() {
    System.out.println("Starting...");

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        try {
          LogService.this.stop();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  /**
   * Stop logging service
   */
  void stop() throws InterruptedException {
    System.out.println("Stopping...");
  }
}
