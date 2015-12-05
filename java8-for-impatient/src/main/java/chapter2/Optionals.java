package chapter2;

import java.util.Optional;

/**
 * Creating and consuming Optional values
 *
 * @author ahalikov
 */
public class Optionals {

  public static void main(String[] args) {
    Optional<Double> d = inverse(0.5);
    d.ifPresent(System.out::println);

    Optional.of(4.0)
      .flatMap(Optionals::inverse)
      .flatMap(Optionals::squareRoot)
      .ifPresent(System.out::println);
  }

  public static Optional<Double> inverse(Double x) {
    return x == 0 ? Optional.empty() : Optional.of(1 / x);
  }

  public static Optional<Double> squareRoot(Double x) {
    return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
  }
}
