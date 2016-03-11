package chapter02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link NthToTheLast}
 *
 * @author ahalikov
 */
public class NthToTheLastTest {
  @Test
  public void testFind() throws Exception {
    assertEquals("Empty list", null, NthToTheLast.find(null, 5));

    // 1-element list
    ListNode head = new ListNode(1, null);
    assertEquals(head, NthToTheLast.find(head, 1));

    ListNode p1 = new ListNode(1, null);
    ListNode p2 = new ListNode(2, null);
    ListNode p3 = new ListNode(3, null);
    ListNode p4 = new ListNode(4, null);
    ListNode p5 = new ListNode(5, null);
    p1.next = p2;
    p2.next = p3;
    p3.next = p4;
    p4.next = p5;
    assertEquals(p1, NthToTheLast.find(p1, 5));
    assertEquals(p3, NthToTheLast.find(p1, 3));
    assertEquals(p5, NthToTheLast.find(p1, 1));
  }
}