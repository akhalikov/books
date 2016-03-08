package chapter02;

import chapter02.Intersection.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author akhalikov
 */
public class IntersectionTest {
  @Test
  public void testFindIntersection() throws Exception {
    Node p3 = new Node(20, null);
    Node p2 = new Node(3, p3);
    Node p1 = new Node(2, p2);

    Node q3 = new Node(4, p2);
    Node q2 = new Node(5, q3);
    Node q1 = new Node(8, q2);

    Node x = Intersection.findIntersection(p1, q1);
    assertEquals("3", 3, x.data);
    assertEquals("20", 20, x.next.data);
    assertEquals("null", null, x.next.next);
  }
}