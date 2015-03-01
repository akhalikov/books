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
