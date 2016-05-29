ExecutorService: 10 Tips and Tricks
===

See http://www.nurkiewicz.com/2014/11/executorservice-10-tips-and-tricks.html

####1. Name pool threads

Default thread pool naming scheme is `pool-N-thread-M` where N stands for pool sequence number 
(every time you create a new thread pool, global counter N is incremented), and M is a thread
sequence number within a pool.

For example, `pool-2-thread-3` means third thread in second thread pool created in the JVM lifecycle.

Obviously, it is not very descriptive.

Here is an example of how to name a thread within a thread pool: [chapter7/DaemonThread.java](https://github.com/akhalikov/books/blob/master/jcp/src/main/java/chapter7/DaemonThread.java)


####2. Switch names according to context

Once we remember about thread names, we can actually change them at runtime whenever we want! 
It makes sense because thread dumps show classes and method names, not parameters and local variables. 
By adjusting thread name to keep some essential transaction identifier we can easily track which message/record/query/etc. is slow or caused deadlock. 

Example:

```java
private void process(String messageId) {
    executorService.submit(() -> {
        final Thread currentThread = Thread.currentThread();
        final String oldName = currentThread.getName();
        currentThread.setName("Processing-" + messageId);
        try {
            //real logic here...
        } finally {
            currentThread.setName(oldName);
        }
    });
}
```

Inside `try-finally` block current thread is named Processing-WHATEVER-MESSAGE-ID-IS. 
This might come in handy when tracking down message flow through the system.

####3. Explicit and safe shutdown

When your application shuts down, you must take care of two things: 
 
 - what is happening with queued tasks, and 
 - how already running tasks are behaving (more on that later).
 
There are two techniques: either let all queued tasks to execute (`shutdown()`) or drop them (`shutdownNow()`) - it totally depends on your use case. 
For example if we submitted a bunch of tasks and want to return as soon as all of them are done, use `shutdown()`: 

```java
private void sendAllEmails(List<String> emails) throws InterruptedException {
    emails.forEach(email ->
            executorService.submit(() ->
                    sendEmail(email)));
    executorService.shutdown();
    final boolean done = executorService.awaitTermination(1, TimeUnit.MINUTES);
    log.debug("All e-mails were sent so far? {}", done);
}
```

In this case we send a bunch of e-mails, each as a separate task in a thread pool. 
After submitting these tasks we shut down pool so that it no longer accepts any new tasks. 
Then we wait at most one minute until all these tasks are completed. 
However if some tasks are still pending, `awaitTermination()` will simply return false.

An alternative to graceful `shutdown()` is `shutdownNow()`:

```java
final List<Runnable> rejected = executorService.shutdownNow();
log.debug("Rejected tasks: {}", rejected.size());
```

This time all queued tasks are discarded and returned. 
Already running jobs are allowed to continue.
 
####4. Handle interruption with care 

See: [InterruptedException and interrupting threads explained](http://www.nurkiewicz.com/2014/05/interruptedexception-and-interrupting.html)

####5. Monitor queue length and keep it bounded

Incorrectly sized thread pools may cause slowness, instability and memory leaks. 
If you configure too few threads, the queue will build up, consuming a lot of memory.
Too many threads on the other hand will slow down the whole system due to excessive context switches - and lead to same symptoms. 
It's important to look at depth of queue and keep it bounded, so that overloaded thread pool simply rejects new tasks temporarily:

```java
final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
executorService = new ThreadPoolExecutor(n, n, 
        0L, TimeUnit.MILLISECONDS,
        queue);
```

Code above is equivalent to `Executors.newFixedThreadPool(n)`, however instead of default unlimited 
`LinkedBlockingQueue` we use `ArrayBlockingQueue` with fixed capacity of 100. 

This means that if 100 tasks are already queued (and n being executed), new task will be rejected with `RejectedExecutionException`. 
Also since queue is now available externally, we can periodically call `size()` and put it in logs/JMX/whatever monitoring mechanism you use.

####6. Remember about exception handling

Thread pool just swallows this exception, as if it never happened:

```java
executorService.submit(() -> {
    System.out.println(1 / 0);
});

```

If you are submitting `Runnable` (without any result, like above), you must surround whole body with `try-catch` and at least log it. 
If you are submitting `Callable<Integer>`, ensure you always dereference it using blocking `get()` to re-throw exception:

```java
final Future<Integer> division = executorService.submit(() -> 1 / 0);
// below will throw ExecutionException caused by ArithmeticException
division.get();
```

####7. Monitor waiting time in a queue

####8. Preserve client stack trace

```java
java.lang.NullPointerException: null
    at com.nurkiewicz.MyTask.call(Main.java:76) ~[classes/:na]
    at com.nurkiewicz.MyTask.call(Main.java:72) ~[classes/:na]
    at java.util.concurrent.FutureTask.run(FutureTask.java:266) ~[na:1.8.0]
    at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) ~[na:1.8.0]
    at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) ~[na:1.8.0]
    at java.lang.Thread.run(Thread.java:744) ~[na:1.8.0]
```
    
We can easily discover that MyTask threw NPE at line 76. 
But we have no idea who submitted this task, because stack trace reveals only `Thread` and `ThreadPoolExecutor`. 
We can technically navigate through the source code in hope to find just one place where MyTask is created. 
But without threads (not to mention event-drivent, reactive, actor-ninja-programming) we would immediately see full picture.    

What if we could preserve stack trace of client code (the one which submitted task) and show it, e.g. in case of failure? 
The idea isn't new, for example Hazelcast propagates exceptions from owner node to client code. 
This is how naïve support for keeping client stack trace in case of failure could look:

https://github.com/akhalikov/books/blob/master/jcp/src/main/java/chapter6/TaskExecutionWebServer.java

This time in case of failure we will retrieve full stack trace and thread name of a place where task was submitted. 
Much more valuable compared to standard exception seen earlier: 

```java
Exception java.lang.NullPointerException in task submitted from thrad main here:
java.lang.Exception: Client stack trace
    at com.nurkiewicz.ExecutorServiceWithClientTrace.clientTrace(ExecutorServiceWithClientTrace.java:43) ~[classes/:na]
    at com.nurkiewicz.ExecutorServiceWithClientTrace.submit(ExecutorServiceWithClientTrace.java:28) ~[classes/:na]
    at com.nurkiewicz.Main.main(Main.java:31) ~[classes/:na]
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0]
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0]
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0]
    at java.lang.reflect.Method.invoke(Method.java:483) ~[na:1.8.0]
    at com.intellij.rt.execution.application.AppMain.main(AppMain.java:134) ~[idea_rt.jar:na]
```    

####9. Prefer CompletableFuture

`CompletableFuture` extends `Future` so everything works as it used to. 
But more advanced consumers of your API will truly appreciate extended functionality given by `CompletableFuture`.

####10. Synchronous queue

Try using `SynchronousQueue` with `ThreadPoolExecutor`:

```java
BlockingQueue<Runnable> queue = new SynchronousQueue<>();
ExecutorService executorService = new ThreadPoolExecutor(2, 2,
        0L, TimeUnit.MILLISECONDS,
        queue);
```
        
We created a thread pool with two threads and a §SynchronousQueue§ in front of it. 
Because §SynchronousQueue§ is essentially a queue with 0 capacity, such §ExecutorService§ will only accept new tasks if there is an idle thread available. 
If all threads are busy, new task will be rejected immediately and will never wait. 
This behavior might be desirable when processing in background must start immediately or be discarded.
        
