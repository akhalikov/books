package chapter1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1.1 and 1.2 Lambda expressions
 *
 * @author ahalikov
 */
public class LambdaSyntax {

    public static void main(String[] args) {

        // Basic comparator
        Comparator<String> comp1 = (String first, String second) -> {
            if (first.length() < second.length()) return -1;
            else if (first.length() > second.length()) return 1;
            else return 0;
        };

        // Reduced form
        Comparator<String> comp2 = (first, second)
                -> Integer.compare(first.length(), second.length());

        // Example of usage
        final String[] words = {"Ant", "No", "More", "Slower"};
        Arrays.sort(words, comp2);
        for (String word : words) {
            System.out.print(word + " ");
        }

        /**
         * Lambda expression cannot be assigned to non-functional interface
         * Compiler error: the type of a lambda expression must be an interface
         */
        //Object o = (String first, String second)
        //        -> Integer.compare(first.length(), second.length());

        /**
         * Checked exeptions and Lambda expressions
         */
        Runnable sleeper = () -> {
            System.out.println("Zzz");

            // This will not compile since InterruptedException is not declared
            // Thread.sleep(1000);
        };
    }
}
