package other.lists;

/**
 * Deep clone singly linked list with random links
 *
 * Created by akhalikov on 25/02/16
 */
public class DeepClone {

  public static Node clone(Node head) {
    Node clone;
    Node curr = head;
    while (curr != null) {
      clone = new Node();
      clone.data = curr.data;
      clone.next = curr.random;

      curr = curr.next;
    }
    return null;
  }

  static class Node {
    int data;
    Node next;
    Node random;
  }
}
