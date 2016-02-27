package careercup.other.lists;

import careercup.other.lists.SwapNodes.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link SwapNodes}
 */
public class SwapNodesTest {
  @Test
  public void testSwap() {
    // 10->15->12->13->20->14
    Node list = new Node(10, new Node(15,
      new Node(12, new Node(13, new Node(20, new Node(14))))));
    Node oldKey1 = list.next.next; // 12
    Node oldKey2 = oldKey1.next.next; // 20

    list = SwapNodes.swap(list, 12, 20);

    Node newKey1 = list.next.next;
    Node newKey2 = newKey1.next.next;

    assertEquals(20, newKey1.key);
    assertEquals(12, newKey2.key);
    assertEquals(newKey1, oldKey2);
    assertEquals(newKey2, oldKey1);
  }

  @Test
  public void testSwapTailHead() {
    // 10->15->12->13->20->14
    Node tail = new Node(14);
    Node list = new Node(10, new Node(15,
      new Node(12, new Node(13, new Node(20, tail)))));
    Node oldKey1 = list; // 10
    Node oldKey2 = tail; // 14

    list = SwapNodes.swap(list, 10, 14);

    Node newKey1 = list;
    Node newKey2 = list.next.next.next.next.next;

    assertEquals(14, newKey1.key);
    assertEquals(10, newKey2.key);
    assertEquals(newKey1, oldKey2);
    assertEquals(newKey2, oldKey1);
  }
}