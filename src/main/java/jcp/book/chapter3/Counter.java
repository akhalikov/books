package jcp.book.chapter3;

/**
 * Created by artur on 04.01.15.
 */
public interface Counter {

    static final int MAX_VALUE = 1000;

    void increment();

    int getValue();
}
