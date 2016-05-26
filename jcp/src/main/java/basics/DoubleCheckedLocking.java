package basics;

/**
 * The (infamous) double-checked locking idiom (also called the multithreaded singleton pattern) is a trick designed
 * to support lazy initialization while avoiding the overhead of synchronization.
 * In very early JVMs, synchronization was slow, and developers were eager to remove it -- perhaps too eager.
 *
 * This looks awfully clever -- the synchronization is avoided on the common code path.
 * There's only one problem with it -- it doesn't work. Why not?
 * The most obvious reason is that the writes which initialize instance and the write to the instance field can be
 * reordered by the compiler or the cache, which would have the effect of returning what appears to be a partially
 * constructed Something.
 *
 * The result would be that we read an uninitialized object.
 * There are lots of other reasons why this is wrong, and why algorithmic corrections to it are wrong.
 * There is no way to fix it using the old Java memory model.
 *
 * Many people assumed that the use of the volatile keyword would eliminate the problems that arise when trying to use
 * the double-checked-locking pattern. In JVMs prior to 1.5, volatile would not ensure that it worked (your mileage may vary).
 * Under the new memory model, making the instance field volatile will "fix" the problems with double-checked locking,
 * because then there will be a happens-before relationship between the initialization of the Something by the
 * constructing thread and the return of its value by the thread that reads it.
 *
 * Instead, use the Initialization On Demand Holder idiom, which is thread-safe and a lot easier to understand:
 * {@link InitOnDemandHolderExample}
 *
 * {@see https://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html}
 */
class DoubleCheckedLocking {

  /**
   * Singleton class
   */
  static class Something {

    private static Something instance = null;

    public static Something getInstance() {
      if (instance == null) {
        synchronized (Something.class) {
          if (instance == null)
            instance = new Something();
        }
      }
      return instance;
    }

    // ...
  }
}
