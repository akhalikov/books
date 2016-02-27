package careercup.other.lists;

/**
 * Given a Linked List.
 * The Linked List is in alternating ascending and descending orders.
 * Sort the list efficiently.
 *
 * Example:
 *
 * Input:   10->40->53->30->67->12->89->NULL
 *          ^       ^       ^       ^
 *
 * Output:  10->12->30->43->53->67->89->NULL
 *
 * Solution:
 *  1) Iterate through the list and build sorted list without alternating nodes
 *  2) Push alternating nodes to stack or another list
 *  3) Merge 1 and 2
 *
 * Created by akhalikov on 27/02/16
 */
public class SortAlternateList {

  static Node sort(Node head) {
    if (head == null)
      throw new NullPointerException("List is null");

    // do nothing if only one item in the list
    if (head.next == null)
      return head;

    Node ascList = new Node(0);
    Node descList = new Node(0);
    splitList(head, ascList, descList);

    return head;
  }

  private static void splitList(Node head, Node ascList, Node descList) {
    Node curr = head,
         ascn = ascList,
         dscn = descList;

    while (curr != null) {
      ascn.next = curr;
      ascn = ascn.next;
      curr = curr.next;

      if (curr != null) {
        dscn.next = curr;
        dscn = dscn.next;
        curr = curr.next;
      }
    }

    ascn.next = null;
    dscn.next = null;
  }

  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
