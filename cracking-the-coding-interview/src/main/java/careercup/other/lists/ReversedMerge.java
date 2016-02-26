package careercup.other.lists;

/**
 * Merge two sorted linked lists such that merged list is in reverse order
 *
 * Given two linked lists sorted in increasing order.
 * Merge them such a way that the result list is in decreasing order (reverse order).
 *
 * Input:
 * a: 5->10->15->40
 * b: 2->3->20
 * Output: 40->20->15->10->5->3->2
 *
 * Input:
 * a: NULL
 * b: 2->3->20
 * Output: 20->3->2
 *
 * @author akhalikov
 */
public class ReversedMerge {
  static class Node {
    int data;
    Node next;

    public Node() {
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  static Node merge(Node first, Node second) {
    Node res = new Node();
    Node p = first, q = second;
    while (p != null && q != null) {
      if (q.data <= p.data) {
        res.data = q.data;
        q = q.next;
      } else {
        res.data = p.data;
        p = p.next;
      }
      Node prev = new Node(0, res);
      res = prev;
    }
    res = mergeRest(p, res);
    res = mergeRest(q, res);
    return res;
  }

  private static Node mergeRest(Node node, Node res) {
    while (node != null) {
      res.data = node.data;
      if (node.next != null) {
        Node prev = new Node(0, res);
        res = prev;
      }
      node = node.next;
    }
    return res;
  }
}
