package chapter5.future.memoizer;

/**
 * @author ahalikov
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
