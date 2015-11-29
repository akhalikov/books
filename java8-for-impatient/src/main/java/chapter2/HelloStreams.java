package chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Let's see what these fancy-shmancy streams are
 *
 * Compared to collections:
 *
 * 1. A stream does not store its elements. They may be stored in an underlying
 * collection or generated on demand
 *
 * 2. Stream operations don’t mutate their source.
 * Instead, they return new streams that hold the result.
 *
 * 3. Stream operations are lazy when possible. This means they are not executed
 * until their result is needed. For example, if you only ask for the first five long
 * words instead of counting them all, then the filter method will stop filtering
 * after the fifth match. As a consequence, you can even have infinite streams!
 *
 * 4. They can be easily parallelized! (loops are not)
 *
 * When you work with streams, you set up a pipeline of operations in three stages:
 *
 * 1. You create a stream.
 *
 * 2. You specify intermediate operations for transforming the initial stream into
 * others, in one or more steps.
 *
 * 3. You apply a terminal operation to produce a result. This operation forces the
 * execution of the lazy operations that precede it. Afterwards, the stream can
 * no longer be used.
 *
 * @author ahalikov
 */
public class HelloStreams {
    public static void main(String[] args) {
        countLongWords("README.md", 10);
    }

    static void countLongWords(String fileName,
                               final int maxLength) {
        String contents = Book.contents();
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // Tssss. look, here it is :)
        long count = words.stream().filter(w -> w.length() > maxLength).count();

        // Let's try in parallel
        long count2 = words.parallelStream().filter(w -> w.length() > maxLength).count();

        // words.stream() - creates a stream
        // .filter() - transforms a stream
        // .count() - terminal operation

        System.out.println("Stream count = " + count);
        System.out.println("Parallel stream count = " + count);
    }


}
