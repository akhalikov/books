package careercup.other.lists;

/**
 * Given a linked list and two integers M and N.
 * Traverse the linked list such that you retain M nodes then delete next N nodes,
 * continue the same till end of the linked list.
 *
 * Input:
 * M = 2, N = 2, Linked List: 1->2->3->4->5->6->7->8
 * Output: 1->2->5->6
 *
 * Input:
 * M = 3, N = 2, Linked List: 1->2->3->4->5->6->7->8->9->10
 * Output: 1->2->3->6->7->8
 *
 * Created by akhalikov on 27/02/16
 */
public class RetainAndDelete {

  static void retainAndDelete(Node head, int m, int n) {
    Node curr = head, temp;

    int countRetain, countDelete;
    while (curr != null) {

      // run through the list and skip nodes
      countRetain = m-1;
      while (curr != null && countRetain > 0) {
        curr = curr.next;
        countRetain--;
      }

      // if end of the list is reached, return
      if (curr == null)
        return;

      // iterate
      temp = curr.next;
      countDelete = n-1;
      while (temp != null && countDelete > 0) {
        temp = temp.next;
        countDelete--;
      }

      if (temp == null)
        curr.next = null;
      else {
        curr.next = temp.next;
        curr = curr.next;
        temp.next = null;
      }
    }
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
