package basics;

import com.ahalikov.toolkit.threads.ThreadHelper;

/**
 * This example shows 5th "happens-before" rule:
 *
 * All actions in a thread happen before any other thread successfully
 * returns from a join() on that thread.
 *
 * {@see https://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html}
 *
 * @author ahalikov
 */
public class WaitingOnJoin {

    public static void main(String[] args) throws Exception {
        //asyncExecution();

        waitingOnJoin();
    }

    /**
     * Code in a thread will be executed asynchronously,
     * so line "I can see this first" can appear before "Hello from Thread-#" in the output.
     */
    static void asyncExecution() {
        System.out.println("Example 1");

        Thread t = new Thread(() -> {
            ThreadHelper.sleepMillis(2);
            System.out.println("Hello from " + Thread.currentThread().getName());
            ThreadHelper.sleepMillis(2);
        });
        t.start();

        System.out.println("I can see this first");
    }

    /**
     * Waiting on join
     *
     * Code in thread will be executed before all actions that go after waiting on join,
     * so the line "Hello from Thread-#" should appear before "I should see this second".
     *
     * @throws InterruptedException
     */
    static void waitingOnJoin() throws InterruptedException {
        System.out.println("Example 2\r\n");

        Thread t = new Thread(() -> {
            ThreadHelper.sleepMillis(2);
            System.out.println("Hello from " + Thread.currentThread().getName());
            ThreadHelper.sleepMillis(2);
        });
        t.start();
        t.join();

        System.out.println("I should see this second");
    }
}
