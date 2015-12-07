package chapter2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Stateful transformations
 *
 * @author ahalikov
 */
public class Stateful {

  public static void main(String[] args) {
    Stream<String> uniqueWords = Stream
      .of("merrily", "merrily", "merrily", "gently")
      .distinct();
    uniqueWords.forEach(s -> System.out.println(s));

    Stream<String> words = Arrays.asList("Maybe", "Leonardo", "Compensation").stream();
    Stream<String> longestFirst = words
      .sorted(Comparator.comparing(String::length)
        .reversed());

    longestFirst.forEach(System.out::println);
  }
}
