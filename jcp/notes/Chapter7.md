Chapter 7. Cancellation and Shutdown
===

### 7.1. Task Cancellation

Reasons why one might want to cancel an activity:

- user-requested cancellation
- time-limited activities
- application events
- errors
- shutdown

There is no safe way to preemptively stop a thread in Java, and therefore no safe way to preemptively stop a task. 
There are only cooperative mechanisms, by which the task and the code requesting cancellation follow an agreed-upon protocol.

Listing 7.1. Using a Volatile Field to Hold Cancellation State.
Listing 7.2. Generating a Second's Worth of Prime Numbers.

See https://github.com/akhalikov/books/blob/master/jcp/src/main/java/chapter7/PrimeGenerator.java

#### 7.1.1. Interruption

Each thread has a boolean interrupted status; interrupting a thread sets its interrupted status to true. 
Thread contains methods for interrupting a thread and querying the interrupted status of a thread, as shown in Listing 7.4. 

The `interrupt` method interrupts the target thread, and `isInterrupted` returns the interrupted status of the target thread. 
The poorly named static `interrupted` method clears the interrupted status of the current thread and returns its previous value; 
this is the only way to clear the interrupted status.

Blocking library methods like `Thread.sleep` and `Object.wait` try to detect when a thread has been interrupted and return early. 
They respond to interruption by clearing the interrupted status and throwing `InterruptedException`, indicating that the blocking operation completed early due to interruption. 
The JVM makes no guarantees on how quickly a blocking method will detect interruption, but in practice this happens reasonably quickly.

Listing 7.3. Unreliable Cancellation that can Leave Producers Stuck in a Blocking Operation. Don't Do this.

See https://github.com/akhalikov/books/blob/master/jcp/src/main/java/chapter7/BrokenPrimeProducer.java

Listing 7.4. Interruption Methods in Thread.

```java
public class Thread {
    public void interrupt() { ... }
    public boolean isInterrupted() { ... }
    public static boolean interrupted() { ... }
    ...
}
```

If a thread is interrupted when it is not blocked, its interrupted status is set, and it is up to the activity being cancelled to poll the interrupted status to detect interruption. 
In this way interruption is "sticky"if it doesn't trigger an `InterruptedException`, evidence of interruption persists until someone deliberately clears the interrupted status.

> Calling interrupt does not necessarily stop the target thread from doing what it is doing; 
  it merely delivers the message that interruption has been requested.
  
**A good way to think about interruption is that it does not actually interrupt a running thread;** it just requests 
that the thread interrupt itself at the next convenient opportunity. (cancellation points.) 
Some methods, such as `wait`, `sleep`, and `join`, take such requests seriously, throwing an exception when they receive an interrupt request or encounter an already set interrupt status upon entry. 

Well behaved methods may totally ignore such requests so long as they leave the interruption request in place so that calling code can do something with it. 
Poorly behaved methods swallow the interrupt request, thus denying code further up the call stack the opportunity to act on it.
  
`BrokenPrimeProducer` illustrates how custom cancellation mechanisms do not always interact well with blocking library methods. 
If you code your tasks to be responsive to interruption, you can use interruption as your cancellation mechanism and take advantage of the interruption support provided by many library classes.  

> Interruption is usually the most sensible way to implement cancellation.

Listing 7.5. Using Interruption for Cancellation.

See https://github.com/akhalikov/books/blob/master/jcp/src/main/java/chapter7/ReliablePrimeProducer.java

#### 7.1.2. Interruption Policies

#### 7.1.3. Responding to Interruption

> Only code that implements a thread's interruption policy may swallow an interruption request.
  General-purpose task and library code should never swallow interruption requests.
  
#### 7.1.4. Example: Timed Run

#### 7.1.5. Cancellation Via Future

#### 7.1.6. Dealing with Non-interruptible Blocking

#### 7.1.7. Encapsulating Nonstandard Cancellation with Newtaskfor
 
### 7.2. Stopping a Thread-based Service 

### 7.3. Handling Abnormal Thread Termination

### 7.4. JVM Shutdown

#### 7.4.1. Shutdown Hooks

Shutdown hooks are unstarted threads that are registered with `Runtime.addShutdownHook`.
The JVM makes no guarantees on the order in which shutdown hooks are started.

Shutdown hooks should be thread-safe: they must use synchronization when accessing shared data and should be careful to avoid deadlock, just like any other concurrent code.
Further, they should not make assumptions about the state of the application 
(such as whether other services have shut down already or all normal threads have completed) or about why the JVM is shutting down, and must therefore be coded extremely defensively.
Finally, they should **exit as quickly as possible**, since their existence delays JVM termination at a time when the user may be expecting the JVM to terminate quickly.

Listing 7.26. Registering a Shutdown Hook to Stop the Logging Service.

See https://github.com/akhalikov/books/blob/master/jcp/src/main/java/chapter7/LogService.java

#### 7.4.2. Daemon Threads

Types of threads: normal and daemon. 

When the JVM starts up, all the threads it creates (such as garbage collector and other housekeeping threads) are daemon threads, 
except the main thread. When a new thread is created, it inherits the daemon status of the thread that created it, 
so by default any threads created by the main thread are also normal threads.

Normal threads and daemon threads differ only in what happens when they exit. When a thread exits, the JVM
performs an inventory of running threads, and if the only threads that are left are daemon threads, it initiates
an orderly shutdown. When the JVM halts, any remaining daemon threads are abandoned `finally` blocks
are not executed, stacks are not unwound the JVM just exits.

> Daemon threads are not a good substitute for properly managing the lifecycle of services within an application.

Example: https://github.com/akhalikov/books/blob/master/jcp/src/main/java/chapter7/DaemonThread.java  

#### 7.4.3. Finalizers