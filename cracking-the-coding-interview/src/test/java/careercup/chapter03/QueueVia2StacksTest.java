package careercup.chapter03;

import algo.queue.Queue;
import static junit.framework.Assert.*;
import org.junit.Test;

/**
 * Test for {@link QueueVia2Stacks}
 *
 * @author akhalikov
 */
public class QueueVia2StacksTest {
  @Test
  public void testAddRemove() throws Exception {
    Queue<String> q = new QueueVia2Stacks<>();
    q.add("one");
    q.add("two");
    q.add("three");
    q.add("four");
    assertFalse(q.isEmpty());

    assertEquals("one", q.remove());
    assertEquals("two", q.remove());
    assertEquals("three", q.remove());
    assertEquals("four", q.remove());
    assertTrue(q.isEmpty());
  }

  @Test
  public void testPeek() throws Exception {
    Queue<String> q = new QueueVia2Stacks<>();
    q.add("one");
    q.add("two");
    q.add("three");
    q.add("four");
    assertFalse(q.isEmpty());

    assertEquals("one", q.peek());
    assertEquals("one", q.remove());

    assertEquals("two", q.peek());
    assertEquals("two", q.remove());
  }
}