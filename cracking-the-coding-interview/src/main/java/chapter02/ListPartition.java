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
   * @param node
   * @return Head node of partitioned list
   */
  static Node partition(Node node, int pivot) {
    if (node == null)
      throw new NullPointerException("List is null");

    Node head = node, tail = node;
    while (node != null) {
      Node next = node.next;
      if (node.data < pivot) {
        node.next = head;
        head = node;
      } else {
        tail.next = node;
        tail = node;
      }
      node = next;
    }
    tail.next = null;
    return head;
  }

  static void print(Node list) {
    while (list != null) {
      System.out.print(list.data + " ");
      list = list.next;
    }
  }

  static class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
