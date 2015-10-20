package common;

/**
 * LaunderThrowable class
 *
 * Coerce an unchecked Throwable to a RuntimeException
 * If the Throwable is an Error, throw it;
 * If it is a RuntimeException return it, otherwise throw IllegalStateException
 */
public class LaunderThrowable {

    public static RuntimeException launder(Throwable t) {
        if (t instanceof RuntimeException)
            return (RuntimeException) t;

        else if (t instanceof Error)
            throw (Error) t;

        else
            throw new IllegalStateException("Not unchecked", t);
    }
}
