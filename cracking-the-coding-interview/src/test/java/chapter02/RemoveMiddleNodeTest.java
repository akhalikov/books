package chapter02;

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
    ListNode p6 = new ListNode(6, null);
    ListNode p5 = new ListNode(5, p6);
    ListNode p4 = new ListNode(4, p5);
    ListNode p3 = new ListNode(3, p4);
    ListNode p2 = new ListNode(2, p3);
    ListNode head = new ListNode(1, p2);

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