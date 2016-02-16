package careercup.chapter02;

import careercup.chapter02.RemoveMiddleNode.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link RemoveMiddleNode}
 *
 * @author ahalikov
 */
public class RemoveMiddleNodeTest {
  @Test
  public void testRemoveNode1() throws Exception {
    // Actual: a->b->c->d->e->f
    Node p6 = new Node("f", null);
    Node p5 = new Node("e", p6);
    Node p4 = new Node("d", p5);
    Node p3 = new Node("c", p4);
    Node p2 = new Node("b", p3);
    Node head = new Node("a", p2);

    RemoveMiddleNode.remove(p3);
    while (head.next != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }

    // Expected: a->b->d->e->f
    assertEquals("d", p3.data);
    assertEquals(p5, p3.next);
  }
}