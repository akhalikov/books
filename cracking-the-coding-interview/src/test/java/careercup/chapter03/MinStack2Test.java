package careercup.chapter03;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link MinStack2}
 *
 * @author akhalikov
 */
public class MinStack2Test {

  @Test
  public void testMin() throws Exception {
    MinStack2 stack = new MinStack2();
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