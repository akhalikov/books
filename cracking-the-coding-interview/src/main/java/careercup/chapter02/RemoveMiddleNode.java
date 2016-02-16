package careercup.chapter02;

/**
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 *
 * Example: node c from a->b->c->d->e->f
 * Result: nothing is returned, but the linked list look like: a->b->d->e->f
 */
public class RemoveMiddleNode {

  static class Node {
    String data;
    Node next;

    public Node(String data, Node next) {
      this.data = data;
      this.next = next;
    }

    @Override
    public String toString() {
      return data;
    }
  }

  static void remove(Node n) {
    if (n == null || n.next == null)
      throw new IllegalArgumentException("n is null or not in the middle");

    Node next = n.next;
    n.data = next.data;
    n.next = next.next;

    // clear node for GC
    next.data = null;
    next.next = null;
  }
}
