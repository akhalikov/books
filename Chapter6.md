Chapter 6 Review
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

####6.2 The Executor Framework

``` java
public interface Executor {
  void execute(Runnable command);
}
```

Based on **producer-consumer pattern**, where activities that submit tasks are the producers, 
and the threads that execute tasks are consumers.

####6.2.3 Thread pools

Main advantage: reusing an existing thread instead of creating a new one.

Pool creation factory methods:

- **newFixedThreadPool**. A fixed-size thread pool creates threads as tasks are submitted, up to the maximum pool size, and then attempts to keep the pool size constant.
- **newCachedThreadPool**. A cached thread pool has more flexibility to reap idle threads when the current size of the pool exceeds the demand for processing, and to add new threads when demand increases, but places no bounds on the size of the pool.
- **newSingleThreadExecutor**. A single-threaded executor guarantees that tasks are processed sequantially (FIFO, LIFO, or priority order).
- **newScheduledThreadPool**. A fixed-size thread pool that supports delayed and periodic task execution, similar to Timer.
- 
####6.2.3 Executor Lifecycle

1. running
2. shutting down
3. terminated

####6.2.5 Delayed and periodic tasks

**ScheduledThreadPoolExecutor** - is replacement of Timer facility.
