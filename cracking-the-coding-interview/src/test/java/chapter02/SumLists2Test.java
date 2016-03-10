package chapter02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test for {@link SumLists2}
 *
 * @author akhalikov
 */
public class SumLists2Test {
  /**
   * (7 1 6) + (5 9 2) = (2 1 9)
   */
  @Test
  public void testSum() {
    ListNode p = new ListNode(7, new ListNode(1, new ListNode(6, null)));
    ListNode q = new ListNode(5, new ListNode(9, new ListNode(2, null)));
    ListNode actual = SumLists2.sum(p, q);
    assertNotNull(actual);
    assertEquals(2, actual.data);
    assertEquals(1, actual.next.data);
    assertEquals(9, actual.next.next.data);
  }

  /**
   * (7) + (5 9 2) = (2 0 3)
   */
  @Test
  public void testSum2() {
    ListNode p = new ListNode(7, null);
    ListNode q = new ListNode(5, new ListNode(9, new ListNode(2, null)));
    ListNode actual = SumLists2.sum(p, q);
    assertNotNull(actual);
    assertEquals(2, actual.data);
    assertEquals(0, actual.next.data);
    assertEquals(3, actual.next.next.data);
  }

  /**
   * (0) + (0) = (0)
   */
  @Test
  public void testSum3() {
    ListNode p = new ListNode(0, null);
    ListNode q = new ListNode(0, null);
    ListNode actual = SumLists2.sum(p, q);
    assertNotNull(actual);
    assertEquals(0, actual.data);
  }
}