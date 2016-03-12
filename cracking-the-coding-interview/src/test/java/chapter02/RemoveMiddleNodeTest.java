package chapter02;

import chapter02.LinkedList.Node;
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
    // Actual: 1->2->3->4->5->6
    Node p6 = new Node(6, null);
    Node p5 = new Node(5, p6);
    Node p4 = new Node(4, p5);
    Node p3 = new Node(3, p4);
    Node p2 = new Node(2, p3);
    Node head = new Node(1, p2);

    RemoveMiddleNode.remove(p3);
    while (head.next != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }

    // Expected: 1-2->4->5->6
    assertEquals(4, p3.data);
    assertEquals(p5, p3.next);
  }
}