Chapter 2: Creating and destroying objects
===

####Item1: Consider static factory methods instead of constructors

Advantages of static factory methods compared to constructors:

1. they have names
2. they are not required to create a new object each time they're invoked
3. they can return an object of any subtype of their return type
  
  Example 1: interface-based frameworks, such as Java Collections Framework (JCF).
  
  > by convention, static factory methods for an interface named ***Type*** are put in a noninstantiable class (Item 4) named ***Types***.
  
  > JCF has 32 convenience implementations of its collection interfaces, providing unmodifiable collections, synchronized collections, etc. Nearly all of these implementations are exported via static factory methods in one noninstantiable class (java.util.Collections). The classes of the returned objects are all nonpublic.
  
  Example 2: service provider frameworks, such as JDBC.
  
  Components of a service provider framework:
  
  - a ***service interface***, which provider implements (`Connection`)
  - a ***provider registration API***, which the system uses to register implementations, giving clients access to them (`DriverManager.registerDriver`).
  - a ***service access API***, which clients use to obtain an instance of the service (`DriverManager.getConnection`).
  
4. they reduce the verbosity of creating parameterized type instances
  
  In case of using constructors:

  ```Map<String, List<String>> m = new HashMap<String, List<String>>();```

  In case of using static factory methods (thanks ***type inference***):
  ```
  public static <K, V> HashMap<K, V> newInstance() {
    return new HashMap<K, V>();
  }
  ...
  Map<String, List<String>> m = HashMap.newInstance();
  ```
  
Disadvantages:

1. Classes without public pr ptotected constructors, cannot be subclassed.
2. Not readily distinguishable from other static methods.
  
  Common names for static factory methods:
    - `valueOf` - Returns an instance that has, loosely speaking, the same value as its parameters. Such static factories are effectively type-conversion methods.
    - `of` - A concise alternative to `valueOf` , popularized by `EnumSet`
    - `getInstance` - Returns an instance that is described by the parameters but cannot be said to have the same value. In the case of a singleton, getInstance takes no parameters and returns the sole instance.
    - `newInstance` - Like `getInstance`, but guarantees that each instance returned is distinct from all others.
    - `getType` - Like `getInstance`, but used when the factory method is in a different class. Type indicates the type of object returned by the factory method.
    - `newType` - Like `newInstance`, but used when the factory method is in a different class. Type indicates the type of object returned by the factory method.

####Item 2: Consider a builder when faced with many constructor parameters

####Item 6: Eliminate obsolete object references

```
// Can you spot the "memory leak"?
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }
    
    /**
    * Ensure space for at least one more element, roughly
    * doubling the capacity each time the array needs to grow.
    */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
```

Memory leaks in garbage-collected languages (more properly known as unintentional object retentions) are insidious. If an object reference is unintentionally retained, not only is that object excluded from garbage collection, but so too are any objects referenced by that object, and so on. Even if only a few object references are unintentionally retained, many, many objects may be prevented from being garbage collected, with potentially large effects on performance.

The fix is simple - null out references once they become obsolete:

```
public Object pop() {
    if (size == 0)
        throw new EmptyStackException();
    Object result =  elements[--size];    
    elements[size] = null; // Eliminate obsolete reference    
    return result;
}
```

> Nulling out object references should be the exception rather than the norm. The best way to eliminate an obsolete reference is to let the variable that contained the reference fall out of scope. This occurs naturally if you define each variable in the narrowest possible scope (**Item 45**).

Sources of memory leaks:

1. if a class manages its own memory (whenever an element is freed, any object references containded in the element should be nulled out) 
2. caches (caches should occasionally be cleansed of entries that have fallen into disuse)
3. listeners and callbacks (clients register callbacks but don't deregister them)
 

####Item 7: Avoid finalizers

> Finalizers are unpredictable, often dangerous, and generally unnecessary.
