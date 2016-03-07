package other.trees;

import org.junit.Test;
import other.trees.TreeNeighbor.Node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Test for {@link TreeNeighbor}
 */
public class TreeNeighborTest {
  @Test
  public void testFillNeighbor() {
    Node nodeF = new Node("F");
    Node nodeE = new Node("E");
    Node nodeD = new Node("D");
    Node nodeB = new Node("B", nodeD, nodeE);
    Node nodeC = new Node("C", null, nodeF);
    Node head = new Node("A", nodeB, nodeC);

    TreeNeighbor.fillNeighbor(head);

    assertNull(head.neighbor);
    assertEquals(nodeC, head.left.neighbor);
    assertNull(head.right.neighbor);
    assertEquals(nodeE, head.left.left.neighbor);
    assertEquals(nodeF, head.left.right.neighbor);
    assertNull(nodeF.neighbor);
  }
}