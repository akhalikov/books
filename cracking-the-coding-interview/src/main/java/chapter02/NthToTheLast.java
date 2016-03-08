package chapter02;

/**
 * Implement an algorithm to find the n-th to last element of a singly linked list.
 */
public class NthToTheLast {

  static class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  static Node find(Node head, int n) {
    if (head == null)
      return null;

    Node p1 = head, p2 = head;
    for (int i = 0; i < n - 1; i++) {
      if (p2 == null)
        return null;
      p2 = p2.next;
    }
    while (p2.next != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    return p1;
  }
}
