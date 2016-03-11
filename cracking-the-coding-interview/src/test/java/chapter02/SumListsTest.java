package chapter02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test for {@link SumLists}
 *
 * @author ahalikov
 */
public class SumListsTest {
  /**
   * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2)
   * Output: 2 -> 1 -> 9
   */
  @Test
  public void testSum() {
    ListNode p = new ListNode(7, new ListNode(1, new ListNode(6, null)));
    ListNode q = new ListNode(5, new ListNode(9, new ListNode(2, null)));
    ListNode actual = SumLists.sum(p, q);
    assertNotNull(actual);
    assertEquals(2, actual.data);
    assertEquals(1, actual.next.data);
    assertEquals(9, actual.next.next.data);
    assertEquals(null, actual.next.next.next);
  }
}