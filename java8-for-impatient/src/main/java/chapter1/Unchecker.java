package chapter1;

/**
 * Uncheck exceptions in Runnable
 *
 * @author ahalikov
 */
public class Unchecker {

    public static void main(String[] args) {
        new Thread(uncheck(
                () -> {
                    System.out.println("Zzzz");
                    Thread.sleep(1000);
                }
        )).start();
    }

    static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    interface RunnableEx {
        void run() throws Exception;
    }
}
