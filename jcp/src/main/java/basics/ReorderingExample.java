package basics;

/**
 * The issue of when a write becomes visible to another thread is compounded by the compiler's reordering of code.
 * For example, the compiler might decide that it is more efficient to move a write operation later in the program;
 * as long as this code motion does not change the program's semantics, it is free to do so.
 * If a compiler defers an operation, another thread will not see it until it is performed;
 * this mirrors the effect of caching.
 *
 * Moreover, writes to memory can be moved earlier in a program; in this case, other threads might see a write before
 * it actually "occurs" in the program.  All of this flexibility is by design -- by giving the compiler, runtime,
 * or hardware the flexibility to execute operations in the optimal order, within the bounds of the memory model,
 * we can achieve higher performance.
 *
 * Let's say that this code is executed in two threads concurrently, and the read of y sees the value 2.
 *
 * Because this write came after the write to x, the programmer might assume that the read of x must see the value 1.
 * However, the writes may have been reordered. If this takes place, then the write to y could happen,
 * the reads of both variables could follow, and then the write to x could take place.
 * The result would be that r1 has the value 2, but r2 has the value 0.
 *
 * {@see https://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html}
 */
public class ReorderingExample {

    static class SharedObject {

        int x = 0, y = 0;

        void write() {
            x = 1;
            y = 2;
        }

        void read() {
            int r1 = y;
            int r2 = x;
        }
    }
}
