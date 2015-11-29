package chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Helper book contents class
 *
 * @author ahalikov
 */
public class Book {

    public static final String FILE_NAME = "README.md";

    public static String contents() {
        String contents = "";
        try {
            contents = new String(
                    Files.readAllBytes(Paths.get(FILE_NAME)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }
}
