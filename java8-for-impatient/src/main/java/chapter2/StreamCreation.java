package chapter2;

import java.util.stream.Stream;

/**
 * @author ahalikov
 */
public class StreamCreation {
    public static void main(String[] args) {
        String contents = Book.contents();

        // Static factory method .of()
        Stream<String> words = Stream.of(contents.split("[\\P{L}]+"));

        // Creating stream from various arguments
        Stream<String> song = Stream.of("gently", "down", "the", "stream");

        // Stream with no elements
        Stream silence = Stream.<String>empty();

        // Stream of constants
        Stream echos = Stream.generate(() -> "Echo");

        // Stream of random numbers
        Stream<Double> randoms = Stream.generate(Math::random);

        // Infinite sequence
        // Stream<Integer> integers
        //        = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
    }
}
