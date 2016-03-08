package chapter02;

import org.junit.Test;

import static chapter02.NthToTheLast.Node;
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
    Node head = new Node(1, null);
    assertEquals(head, NthToTheLast.find(head, 1));

    Node p1 = new Node(1, null);
    Node p2 = new Node(2, null);
    Node p3 = new Node(3, null);
    Node p4 = new Node(4, null);
    Node p5 = new Node(5, null);
    p1.next = p2;
    p2.next = p3;
    p3.next = p4;
    p4.next = p5;
    assertEquals(p1, NthToTheLast.find(p1, 5));
    assertEquals(p3, NthToTheLast.find(p1, 3));
    assertEquals(p5, NthToTheLast.find(p1, 1));
  }
}