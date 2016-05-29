package tipsandtricks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.stream.Collectors.toList;

abstract class ExecutorServiceWithClientTrace implements ExecutorService {
  protected final Logger log = LoggerFactory.getLogger(ExecutorServiceWithClientTrace.class);
  protected final ExecutorService target;

  public ExecutorServiceWithClientTrace(ExecutorService target) {
    this.target = target;
  }

  @Override
  public <T> Future<T> submit(Callable<T> task) {
    return target.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
  }

  private Exception clientTrace() {
    return new Exception("Client stack trace");
  }

  private <T> Callable<T> wrap(final Callable<T> task,
                               final Exception clientStack,
                               String clientThreadName) {
    return () -> {
      try {
        return task.call();
      } catch (Exception e) {
        log.error("Exception {} in task submitted from thread {} here: ",
          e, clientThreadName, clientStack);
        throw e;
      }
    };
  }

  @Override
  public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
    return tasks.stream().map(this::submit).collect(toList());
  }
}
