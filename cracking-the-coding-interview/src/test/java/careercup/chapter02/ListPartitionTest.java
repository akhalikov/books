package careercup.chapter02;

import careercup.chapter02.ListPartition.Node;
import org.junit.Test;

/**
 * @author akhalikov
 */
public class ListPartitionTest {

  @Test
  public void testPartition() throws Exception {
    Node list1 = new Node(3, new Node(5, new Node(8,
      new Node(5, new Node(10, new Node(2, new Node(1, null)))))));
    Node result = ListPartition.partition(list1, 5);
    ListPartition.print(result);

    System.out.println();
    Node list2 = new Node(10, new Node(11, new Node(12,
      new Node(0, new Node(1, new Node(2, new Node(3, null)))))));
    result = ListPartition.partition(list2, 5);
    ListPartition.print(result);

    System.out.println();
    Node list3 = new Node(1, null);
    result = ListPartition.partition(list3, 100);
    ListPartition.print(result);
  }
}