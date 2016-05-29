Chapter 6: Task Execution
===

> Tasks - independent activities (in ideal).
  Independent tasks can be executed in parallel.
  
Server apps should exhibit:

- good throughput
- good responsiveness under normal load
- graceful degradation as they become overloaded (rather than simply falling down)

> Solution: choosing good **task boundaries**, coupled with a sensible task execution policy.
One of the most common natural task boundaries: individual client requests.

Disadvantages of unbounded thread creation:

- Thread lifecycle overhead (Thread creation and teardown are not free)
- Resource consumption (Risk of consuming a lot of memory and CPU time)
- Stability (Risk of OutOfMemoryError when hitting the limit of threads)

###6.2 The Executor Framework

Tasks are logical units of work, and threads are a mechanism by which tasks can run asynchronously.
Thread pools offer the same benefit for thread management, and `java.util.concurrent` provides a flexible 
thread pool implementation as part of the Executor framework. The primary abstraction for task execution in the Java 
class libraries is not Thread, but Executor:

``` java
public interface Executor {
  void execute(Runnable command);
}
```

`Executor` interface provides a standard means of decoupling task submission from task execution, 
describing tasks with Runnable. The Executor implementations also provide lifecycle support and hooks for 
adding statistics gathering, application management, and monitoring.

Based on **producer-consumer pattern**, where activities that submit tasks are the producers, 
and the threads that execute tasks are consumers.

####6.2.1. Example: Web Server Using Executor

See https://github.com/akhalikov/books/blob/master/jcp/src/main/java/chapter6/TaskExecutionWebServer.java

####6.2.2. Execution Policies

An execution policy specifies the "what, where, when, and how" of task execution, including:

```java
public class WithinThreadExecutor implements Executor {
    public void execute(Runnable r) {
        r.run();
    };
}
```

- In what thread will tasks be executed?
- In what order should tasks be executed (FIFO, LIFO, priority order)?
- How many tasks may execute concurrently?
- How many tasks may be queued pending execution?
- If a task has to be rejected because the system is overloaded, which task should be selected as the victim, and how should the application be notified?
- What actions should be taken before or after executing a task?

> Whenever you see code of the form: `new Thread(runnable).start()` and you think you might at some point want a more flexible execution policy, seriously consider replacing it with the use of an Executor.

####6.2.3 Thread pools

A thread pool, as its name suggests, manages a homogeneous pool of worker threads. 
A thread pool is tightly bound to a work queue holding tasks waiting to be executed. 
Worker threads have a simple life: request the next task from the work queue, execute it, and go back to waiting for another task.

Main advantage: reusing an existing thread instead of creating a new one.

Pool creation factory methods:

- **newFixedThreadPool**. A fixed-size thread pool creates threads as tasks are submitted, up to the maximum pool size, and then attempts to keep the pool size constant.
- **newCachedThreadPool**. A cached thread pool has more flexibility to reap idle threads when the current size of the pool exceeds the demand for processing, and to add new threads when demand increases, but places no bounds on the size of the pool.
- **newSingleThreadExecutor**. A single-threaded executor guarantees that tasks are processed sequantially (FIFO, LIFO, or priority order).
- **newScheduledThreadPool**. A fixed-size thread pool that supports delayed and periodic task execution, similar to Timer.

####6.2.4 Executor Lifecycle

1. **running** - initial state.
2. shutting down
3. terminated

Listing 6.7. Lifecycle Methods in ExecutorService.

```java
public interface ExecutorService extends Executor {
    void shutdown();
    List<Runnable> shutdownNow();
    boolean isShutdown();
    boolean isTerminated();
    boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;
    // ... additional convenience methods for task submission
}
```

- The **shutdown** method initiates a graceful shutdown: no new tasks are accepted but previously submitted tasks are allowed to completeincluding those that have not yet begun execution.
- The **shutdownNow** method initiates an abrupt shutdown: it attempts to cancel outstanding tasks and does not start any tasks that are queued but not begun.

Tasks submitted to an ExecutorService after it has been shut down are handled by the rejected execution 
handler (see Section 8.3.3), which might silently discard the task or might cause execute to throw the 
unchecked `RejectedExecutionException`. Once all tasks have completed, the ExecutorService transitions to the terminated state.

You can wait for an `ExecutorService` to reach the terminated state with `awaitTermination`, or poll for whether 
it has yet terminated with `isTerminated`. It is common to follow shutdown immediately by `awaitTermination`, 
creating the effect of synchronously shutting down the `ExecutorService`.

Listing 6.8. Web Server with Shutdown Support.

####6.2.5 Delayed and periodic tasks

**ScheduledThreadPoolExecutor** - is replacement of Timer facility.

### 6.3. Finding Exploitable Parallelism

Listing 6.9. Class Illustrating Confusing Timer Behavior.
See https://github.com/akhalikov/books/blob/master/jcp/src/main/java/chapter6/OutOfTime.java

#### 6.3.2. Result-bearing Tasks: Callable and Future

Many tasks are effectively deferred computations executing a database query, fetching a resource over the network, 
or computing a complicated function. For these types of tasks, `Callable` is a better abstraction: 
it expects that the main entry point, call, will return a value and anticipates that it might throw an exception.

`Future` represents the lifecycle of a task and provides methods to test whether the task has completed or 
been cancelled, retrieve its result, and cancel the task.

The behavior of `get` varies depending on the task state (not yet started, running, completed). 
It returns immediately or throws an `Exception` if the task has already completed, but if not it blocks until the task
completes. If the task completes by throwing an exception, `get` rethrows it wrapped in an `ExecutionException`; 
if it was cancelled, `get` throws `CancellationException`. 
If `get` throws `ExecutionException`, the underlying exception can be retrieved with `getCause`.

```java
public interface Callable<V> {
    V call() throws Exception;
}

public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning);
    boolean isCancelled();
    boolean isDone();
    V get() throws InterruptedException, ExecutionException, CancellationException;
    V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, CancellationException, TimeoutException;
}
```

