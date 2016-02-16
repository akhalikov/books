package careercup.chapter03;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link MinStack}
 *
 * @author ahalikov
 */
public class MinStackTest {

  @Test
  public void testPop() throws Exception {
    MinStack<Integer> stack = new MinStack();
    stack.push(2);
    stack.push(3);
    stack.push(154);
    assertEquals(Integer.valueOf(154), stack.pop());
    assertEquals(Integer.valueOf(3), stack.pop());
    assertEquals(Integer.valueOf(2), stack.pop());
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testMin() throws Exception {
    MinStack<Integer> stack = new MinStack();
    stack.push(3);
    stack.push(2);
    stack.push(154);
    assertEquals(Integer.valueOf(2), stack.min());
    stack.push(-6);
    assertEquals(Integer.valueOf(-6), stack.min());
  }

  @Test
  public void testMin2() throws Exception {
    MinStack<Integer> stack = new MinStack();
    stack.push(3);
    stack.push(2);
    stack.push(154);
    stack.push(-10);

    assertEquals(Integer.valueOf(-10), stack.min());

    stack.pop();
    assertEquals(Integer.valueOf(2), stack.min());
  }
}