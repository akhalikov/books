package chapter02;

import org.junit.Test;

/**
 * Test for {@link ListPartition}
 *
 * @author akhalikov
 */
public class ListPartitionTest {
  @Test
  public void testPartition() throws Exception {
    ListNode list1 = new ListNode(3, new ListNode(5, new ListNode(8,
      new ListNode(5, new ListNode(10, new ListNode(2, new ListNode(1, null)))))));
    ListNode result = ListPartition.partition(list1, 5);
    ListPartition.print(result);

    System.out.println();
    ListNode list2 = new ListNode(10, new ListNode(11, new ListNode(12,
      new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, null)))))));
    result = ListPartition.partition(list2, 5);
    ListPartition.print(result);

    System.out.println();
    ListNode list3 = new ListNode(1, null);
    result = ListPartition.partition(list3, 100);
    ListPartition.print(result);
  }
}