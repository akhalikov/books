package chapter03;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinStack2Test {

    @Test
    @Ignore // TODO Fix
    public void testMin() {
        // given
        var stack = new MinStack2();

        // when / then
        stack.push(5);
        assertEquals(5, (int) stack.min());
        stack.push(6);
        assertEquals(5, (int) stack.min());
        stack.push(3);
        assertEquals(3, (int) stack.min());
        stack.push(7);
        assertEquals(3, (int) stack.min());
        stack.pop();
        assertEquals(3, (int) stack.min());
        stack.pop();
        assertEquals(5, (int) stack.min());
    }
}