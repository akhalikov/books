package chapter02;

/**
 * Write code to partition LL around a value x,
 * such that all nodes less than x come before all nodes >= x.
 *
 * If x is contained within the list, the values of x only need to be after the elements < x.
 *
 * The partition element x can appear anywhere in the 'right partition';
 * it does not need to appear between the left and right partitions.
 *
 * Input:
 * 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition =5]
 *
 * Output:
 * 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *
 * @author akhalikov
 */
public class ListPartition {
  /**
   * Just put bigger items to the end of the list, smaller to the head.
   * @param ListNode
   * @return Head ListNode of partitioned list
   */
  static ListNode partition(ListNode ListNode, int pivot) {
    if (ListNode == null)
      throw new NullPointerException("List is null");

    ListNode head = ListNode, tail = ListNode;
    while (ListNode != null) {
      ListNode next = ListNode.next;
      if (ListNode.data < pivot) {
        ListNode.next = head;
        head = ListNode;
      } else {
        tail.next = ListNode;
        tail = ListNode;
      }
      ListNode = next;
    }
    tail.next = null;
    return head;
  }

  static void print(ListNode list) {
    while (list != null) {
      System.out.print(list.data + " ");
      list = list.next;
    }
  }
}
