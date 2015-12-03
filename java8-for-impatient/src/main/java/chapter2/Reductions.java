package chapter2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Reduction examples
 *
 * @author ahalikov
 */
public class Reductions {

  final static List<String> WORDS = Arrays.asList("Maybe", "Leonardo", "Compensation", "QA");

  public static void main(String[] args) {
    // Using max
    Optional<String> largest = WORDS.stream()
      .max(String::compareToIgnoreCase);
    if (largest.isPresent()) {
      System.out.println("the largest: " + largest.get());
    }

    // Using findFirst
    Optional<String> startsWithQ = WORDS.stream()
      .filter(s -> s.startsWith("Q")).findFirst();
    System.out.println(startsWithQ.isPresent() ? startsWithQ.get() : "No luck with Q");

    // Using findAny
    Optional<String> startsWithQ2 = WORDS.stream()
      .parallel().filter(s -> s.startsWith("Q")).findAny();
    System.out.println(startsWithQ2.isPresent() ? startsWithQ2.get() : "No luck with Q");
  }
}
