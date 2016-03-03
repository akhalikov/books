package other.lists;

import other.lists.RetainAndDelete.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test RetainAndDeleteTest
 */
public class RetainAndDeleteTest {
  @Test
  public void test1() {
    // 1->2->3->4->5->6->7->8, m=2, n=2
    Node list = new Node(1, new Node(2, new Node(3, new Node(4,
      new Node(5, new Node(6, new Node(7, new Node(8))))))));
    RetainAndDelete.retainAndDelete(list, 2, 2);

    // 1->2->5->6
    Node expected = new Node(1, new Node(2, new Node(5, new Node(6))));
    while (list != null && expected != null) {
      assertEquals(expected.data, list.data);
      expected = expected.next;
      list = list.next;
    }
  }

  @Test
  public void test2() {
    // 1->2->3->4->5->6->7->8->9->10, M = 3, N = 2
    Node list = new Node(1, new Node(2, new Node(3, new Node(4,
      new Node(5, new Node(6, new Node(7,
        new Node(8, new Node(9, new Node(10))))))))));
    RetainAndDelete.retainAndDelete(list, 3, 2);

    // 1->2->3->6->7->8
    Node expected = new Node(1, new Node(2, new Node(3,
      new Node(6, new Node(7, new Node(8))))));
    while (list != null && expected != null) {
      assertEquals(expected.data, list.data);
      expected = expected.next;
      list = list.next;
    }
  }
}