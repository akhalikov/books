package careercup.chapter02;

import careercup.chapter02.SumLists.Node;
import org.junit.Test;

import static org.junit.Assert.*;

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
    Node p = new Node(7, new Node(1, new Node(6, null)));
    Node q = new Node(5, new Node(9, new Node(2, null)));
    Node actual = SumLists2.sum(p, q);
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
    Node p = new Node(7, null);
    Node q = new Node(5, new Node(9, new Node(2, null)));
    Node actual = SumLists2.sum(p, q);
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
    Node p = new Node(0, null);
    Node q = new Node(0, null);
    Node actual = SumLists2.sum(p, q);
    assertNotNull(actual);
    assertEquals(0, actual.data);
  }
}