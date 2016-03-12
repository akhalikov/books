package chapter02;

import chapter02.LinkedList.Node;
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
    Node head = new Node(1, null);
    assertEquals(head, NthToTheLast.find(head, 1));

    LinkedList list1 = LinkedList.fromArray(1, 2, 3, 4, 5);
    Node[] nodes = list1.toArray();

    assertEquals(nodes[0], NthToTheLast.find(list1.head, 5));
    assertEquals(nodes[2], NthToTheLast.find(list1.head, 3));
    assertEquals(nodes[4], NthToTheLast.find(list1.head, 1));
  }
}