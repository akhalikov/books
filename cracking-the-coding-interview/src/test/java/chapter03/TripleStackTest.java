package chapter03;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link TripleStack}
 *
 * @author akhalikov
 */
public class TripleStackTest {
  @Test
  public void testPush() throws Exception {
    TripleStack<String> stack = createNonEmptyStack();
    assertFalse(stack.isEmpty(1));
    assertFalse(stack.isEmpty(2));
    assertFalse(stack.isEmpty(3));
  }

  @Test
  public void testPop() throws Exception {
    TripleStack<String> stack = createNonEmptyStack();
    assertFalse(stack.isEmpty(1));
    assertFalse(stack.isEmpty(2));
    assertFalse(stack.isEmpty(3));

    assertEquals("year", stack.pop(3));
    assertEquals("books", stack.pop(3));
    assertEquals("Three", stack.pop(3));
    assertTrue(stack.isEmpty(3));

    assertEquals("Mars", stack.pop(1));
    assertEquals("Hello", stack.pop(1));
    assertTrue(stack.isEmpty(1));
  }

  private TripleStack<String> createNonEmptyStack() {
    TripleStack<String> stack = new TripleStack();
    stack.push("Hello", 1);
    stack.push("Mars", 1);

    stack.push("Hey", 2);
    stack.push("You", 2);

    stack.push("Three", 3);
    stack.push("books", 3);
    stack.push("year", 3);
    return stack;
  }
}