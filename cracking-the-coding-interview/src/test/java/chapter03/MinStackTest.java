package chapter03;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {

    @Test
    public void testPop() {
        // given
        var stack = new MinStack<>();
        stack.push(2);
        stack.push(3);
        stack.push(154);

        // when / then
        assertEquals(154, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    @Ignore // TODO Fix
    public void testMin() {
        // given
        var stack = new MinStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(154);

        // when / then
        assertEquals(2, stack.min());
        stack.push(-6);
        assertEquals(-6, stack.min());
    }

    @Test
    @Ignore // TODO Fix
    public void testMin2() {
        // given
        var stack = new MinStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(154);
        stack.push(-10);

        // when / then
        assertEquals(-10, stack.min());

        stack.pop();
        assertEquals(2, stack.min());
    }
}