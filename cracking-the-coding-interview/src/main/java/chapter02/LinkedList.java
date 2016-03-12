package chapter02;

/**
 * Basic linked list implementation
 *
 * Created by akhalikov on 11/03/16
 */
public class LinkedList {
  Node head;
  int size;

  public LinkedList() {
  }

  public static LinkedList fromArray(int...data) {
    LinkedList list = new LinkedList();
    Node prev = null;
    for (int i = 0; i < data.length; i++) {
      Node node = new Node(data[i]);
      if (i == 0)
        list.head = node;
      if (prev != null)
        prev.next = node;
      prev = node;
    }
    list.size = data.length;
    return list;
  }

  public Node[] toArray() {
    Node[] nodes = new Node[size];
    Node curr = head;
    for (int i = 0; i < size; i++) {
      nodes[i] = curr;
      curr = curr.next;
    }
    return nodes;
  }

  public static class Node {
    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
      this.data = data;
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    @Override
    public String toString() {
      return String.valueOf(data);
    }
  }
}
