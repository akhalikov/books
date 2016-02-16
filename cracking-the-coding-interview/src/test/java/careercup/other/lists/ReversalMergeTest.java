package careercup.other.lists;

import careercup.other.lists.ReversalMerge.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author akhalikov
 */
public class ReversalMergeTest {
  @Test
  public void testMerge() throws Exception {
    // 5->10->15->40
    Node first = new Node(5, new Node(10, new Node(15, new Node(40, null))));
    // 2->3->20
    Node second = new Node(2, new Node(3, new Node(20, null)));

    Node actual = ReversalMerge.merge(first, second);
    // 40->20->15->10->5->3->2
    int[] expected = {40, 20, 15, 10, 5, 3, 2};
    int i = 0;
    while (actual != null) {
      assertEquals(""+i, expected[i], actual.data);
      actual = actual.next;
      i++;
    }
  }

  @Test
  public void testMerge2() throws Exception {
    // null
    Node first = null;
    // 2->3->20
    Node second = new Node(2, new Node(3, new Node(20, null)));
    Node actual = ReversalMerge.merge(first, second);
    int[] expected = {20, 3, 2};
    int i = 0;
    while (actual != null) {
      assertEquals(""+i, expected[i], actual.data);
      actual = actual.next;
      i++;
    }
  }
}