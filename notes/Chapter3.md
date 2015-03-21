Chapter 3 Review
===

####3.1.4 Volatile variables - are weaker form of synchronization.

Why is it weaker form?

> When a field is declared volatile, the compiler and runtime are put on notice that this variable is shared, and that operations on it should not be reordered with other memory operations. Volatile variables are not cached in registers or in caches where they are hidden from other processors, so a read of volatile variable always return the most recent write by any thread.

1. Does accessing volatile variables perform any locking ?
2. Can accessing volatile variable cause executing thread to block ? Why ?
3. When using volatile is enough ?
4. What are the best practices of using volatile variables ? Examples.
5. Is it true that volatile reads much more expensive than usual reads on most of the current processor architectures ?
6. Is there any difference between Client JVM and Server JVM in terms of optimisations ?
7. Is semantics of volatile strong enough to make the increment operation (count++) atomic ? Why ?

> Locking can guarantee both visibility and atomicity; 
volatile variables can guarantee visibility.

9. What criterias should met for using volatile variables ?

####3.2 Publication and escape

1. What does it mean "object escaped" ? How it could be? 
2. Examples of escaping.

####3.3 Thread confinement

1. What is thread confinement ? Examples.
2. Explain ad-hoc thread confinement in case of volatile variables ?
3. What is stack confinement ?

####3.4 Immutability

1. When an object is immutable ? (state, fields, construction)
2. Example of using volatile to publish immutable objects.
3. Can immutable objects be used safely without synchronization ?
4. Is there any restriction on publishing immutable objects ?
5. What objects are effectively immutable ? Is there any restriction on publishing such objects ?
    
> Objects that are not immutable must be safely published, which usually entails synchronization by both the publishing and the consuming thread. 
> To publish an object safely, both the reference to the object and the object's state must be made visible to other threads at the same time.
> 
> A properly constructed object can be safely published by:
> 
> - Initializing an object reference from a static initializer;
> - Storing a reference to it into a volatile field or AtomicReference;
> - Storing a reference to it into a final field of a properly constructed object; or
> - Storing a reference to it into a field that is properly guarded by a lock.

####3.3.5 Mutable objects

The publication requirements for an object depend on its mutability:

- Immutable objects can be published through any mechanism;
- Effectively immutable objects must be safely published;
- Mutable objects must be safely published, and must be either thread safe or guarded by a lock.

The most useful policies for using and sharing objects in a concurrent program are: 

- **Thread confined**. A thread confined object is owned exclusively by and confined to one thread, and can be modified by its owning thread. 

- **Shared read only**. A shared read only object can be accessed concurrently by multiple threads without additional synchronization,  but cannot be modified by any thread.  
Shared read only objects include immutable and effectively immutable objects. 

- **Shared thread safe**. A thread safe object performs synchronization internally, so multiple threads can freely access  it through its public interface without further synchronization. 

- **Guarded**. A guarded object can be accessed only with a specific lock held. Guarded objects include those that are encapsulated within other thread safe objects and published objects that are known to be guarded by a specific lock. 
