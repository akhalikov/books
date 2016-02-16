package careercup.other.lists;

/**
 * Rearrange linked list in-place
 *
 * Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
 * Rearrange the nodes in the list so that the new formed list is:
 * L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 ...
 *
 * Created by akhalikov on 28.09.2015.
 */
public class RearrangeList {

  static <E> Node<E> rearrange(Node<E> first) {
    int count = 0;
    Node<E> curr = first;
    while (curr != null) {
      curr = curr.next;
      count++;
    }
    int mid = count / 2, i = 0;
    Node<E> left = first;
    curr = first;
    while (i < mid) {
      left = left.next;
    }
    return null;
  }

  public static final class Node<E> {
    E item;
    Node<E> next;

    public Node(E item) {
      this.item = item;
    }

    public Node(E item, Node<E> next) {
      this.item = item;
      this.next = next;
    }
  }
}
