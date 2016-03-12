package chapter02;

import chapter02.LinkedList.Node;
import org.junit.Test;

/**
 * Test for {@link ListPartition}
 *
 * @author akhalikov
 */
public class ListPartitionTest {
  @Test
  public void testPartition() throws Exception {
    LinkedList list1 = LinkedList.fromArray(3, 5, 8, 5, 10, 2, 1);
    Node result = ListPartition.partition(list1.head, 5);
    ListPartition.print(result);

    System.out.println();
    LinkedList list2 = LinkedList.fromArray(10, 11, 12, 0, 1, 2, 3);
    result = ListPartition.partition(list2.head, 5);
    ListPartition.print(result);

    System.out.println();
    Node list3 = new Node(1);
    result = ListPartition.partition(list3, 100);
    ListPartition.print(result);
  }
}