package chapter1;

/**
 * 1.6 Variable scopes (a.k.a. closures)
 *
 * @author ahalikov
 */
public class VariableScopes {

    public static void main(String[] args) {
        repeatMessage("Yay!", 10);
    }

    public static void repeatMessage(String text, int count) {

        // Closure: captures the values of a variables in the enclosing scope,
        // namely text and count
        // and Java requires these variables do not change

        Runnable r = () -> {
            while (count > 0) {
                // count--; // Error: Can’t mutate captured variable

                System.out.println(Thread.currentThread().getName() + ": " + text);
                Thread.yield();
            }
        };
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
