package chapter02;

import chapter02.LinkedList.Node;
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
    Node p = new Node(7, new Node(1, new Node(6, null)));
    Node q = new Node(5, new Node(9, new Node(2, null)));
    Node actual = SumLists.sum(p, q);
    assertNotNull(actual);
    assertEquals(2, actual.data);
    assertEquals(1, actual.next.data);
    assertEquals(9, actual.next.next.data);
    assertEquals(null, actual.next.next.next);
  }
}