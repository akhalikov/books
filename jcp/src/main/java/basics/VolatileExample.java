package basics;

/**
 * Under the new memory model, it is still true that volatile variables cannot be reordered with each other.
 * The difference is that it is now no longer so easy to reorder normal field accesses around them.
 * Writing to a volatile field has the same memory effect as a monitor release,
 * and reading from a volatile field has the same memory effect as a monitor acquire.
 * In effect, because the new memory model places stricter constraints on reordering of volatile field accesses
 * with other field accesses, volatile or not, anything that was visible to thread A when it writes to volatile field f
 * becomes visible to thread B when it reads f.
 *
 * Assume that one thread is calling writer, and another is calling reader.
 * The write to v in writer releases the write to x to memory, and the read of v acquires that value from memory.
 * Thus, if the reader sees the value true for v, it is also guaranteed to see the write to 42 that happened before it.
 * This would not have been true under the old memory model.
 * If v were not volatile, then the compiler could reorder the writes in writer, and reader's read of x might see 0.
 *
 * Effectively, the semantics of volatile have been strengthened substantially, almost to the level of synchronization.
 * Each read or write of a volatile field acts like "half" a synchronization, for purposes of visibility.
 *
 * Important Note: Note that it is important for both threads to access the same volatile variable in order to properly
 * set up the happens-before relationship. It is not the case that everything visible to thread A when it writes
 * volatile field f becomes visible to thread B after it reads volatile field g.
 * The release and acquire have to "match" (i.e., be performed on the same volatile field) to have the right semantics.
 *
 * {@see https://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html}
 */
class VolatileExample {

  int x = 0;

  volatile boolean v = false;

  public void writer() {
    x = 42;
    v = true;
  }

  public void reader() {
    if (v == true) {
      // uses x - guaranteed to see 42.
      int t = x;
      System.out.println(t);
    }
  }
}
