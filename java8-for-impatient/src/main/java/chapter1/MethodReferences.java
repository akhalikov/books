package chapter1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1.4 Example of method references
 *
 * Three principal cases:
 *
 * 1) object::instanceMethod
 * 2) Class::staticMethod
 * 3) Class::instanceMethod
 *
 * @author ahalikov
 */
public class MethodReferences {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("dark", "Bee", "around", "Creative", "near");

        // String::compareToIgnoreCase is the same as (x, y) -> x.compareToIgnoreCase(y).
        Collections.sort(words, String::compareToIgnoreCase);

        // System.out::println is equivalent to x -> System.out.println(x).
        words.forEach(System.out::println);
    }

    static class Greeter {
        public void greet() {
            System.out.println("Hello, world!");
        }
    }
    static class ConcurrentGreeter extends Greeter {
        public void greet() {
            Thread t = new Thread(super::greet);
            t.start();
        }
    }
}
