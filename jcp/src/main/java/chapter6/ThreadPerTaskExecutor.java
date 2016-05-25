package chapter6;

import java.util.concurrent.Executor;

/**
 * Listing 6.5. Executor that Starts a New Thread for Each Task
 */
public class ThreadPerTaskExecutor implements Executor {
  @Override
  public void execute(Runnable command) {
    new Thread(command).start();
  }
}
