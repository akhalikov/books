package careercup.chapter03;

import algo.stack.LinkedStack;
import algo.stack.Stack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link SortStack}
 *
 * @author akhalikov
 */
public class SortStackTest {
  @Test
  public void testSort() throws Exception {
    Stack<Integer> stack = new LinkedStack<>();
    stack.push(12);
    stack.push(8);
    stack.push(10);
    stack.push(11);
    stack.push(5);

    Stack<Integer> sorted = SortStack.sort(stack);
    assertEquals(5, (int) sorted.pop());
    assertEquals(8, (int) sorted.pop());
    assertEquals(10, (int) sorted.pop());
    assertEquals(11, (int) sorted.pop());
    assertEquals(12, (int) sorted.pop());
  }
}