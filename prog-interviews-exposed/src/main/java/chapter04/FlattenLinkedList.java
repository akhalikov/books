package chapter04;

/**
 * Start with a standard doubly-linked list.
 * Now imagine that in addition to next and previous pointers,
 * each element has a child pointer, which may or may not point to a
 * separate doubly-linked list. These child lists may have one or more children of their
 * own, and so on, to produce a multilevel data structure, as shown in Figure 4-3.
 * Flatten the list so that all the nodes appear in a single-level, doubly-linked list.
 *
 * Created by akhalikov on 07/03/16
 */
public class FlattenLinkedList {

  static void flatten(Node head, Node tail) {

  }

  static class Node {
    int value;

    Node next;
    Node prev;
    Node child;

    public Node(int value) {
      this.value = value;
    }

    public Node(int value, Node prev, Node next) {
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
  }
}
