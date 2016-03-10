package chapter02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author akhalikov
 */
public class IntersectionTest {
  @Test
  public void testFindIntersection() throws Exception {
    ListNode p3 = new ListNode(20, null);
    ListNode p2 = new ListNode(3, p3);
    ListNode p1 = new ListNode(2, p2);

    ListNode q3 = new ListNode(4, p2);
    ListNode q2 = new ListNode(5, q3);
    ListNode q1 = new ListNode(8, q2);

    ListNode x = Intersection.findIntersection(p1, q1);
    assertEquals("3", 3, x.data);
    assertEquals("20", 20, x.next.data);
    assertEquals("null", null, x.next.next);
  }
}