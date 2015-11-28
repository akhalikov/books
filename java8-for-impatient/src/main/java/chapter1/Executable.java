package chapter1;

/**
 * 1.3 Example of functional interface
 *
 * You can tag any functional interface with the @FunctionalInterface annotation.
 * This has two advantages.
 *
 * The compiler checks that the annotated entity is an interface with a single abstract method.
 * And the javadoc page includes a statement that your interface is a functional interface.
 * It is not required to use the annotation. Any interface with a single abstract method is,
 * by definition, a functional interface.
 *
 * But using the @FunctionalInterface annotation is a good idea
 */
@FunctionalInterface
public interface Executable {
    void execute();
}
