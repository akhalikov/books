package chapter1;

import javafx.scene.control.Button;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1.5 Constructor References
 *
 * Constructor references are just like method references,
 * except that the name of the method is new.
 *
 * @author ahalikov
 */
public class ConstructorReferences {

    public static void main(String[] args) {
    }

    static void someUiToolkit() {
        List<String> labels = Arrays.asList("Button 1", "Button 2", "Button 3");
        Stream<Button> stream = labels.stream().map(Button::new);
        List<Button> buttons = stream.collect(Collectors.toList());
    }
}
