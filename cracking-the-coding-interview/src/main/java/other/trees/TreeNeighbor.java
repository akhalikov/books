package other.trees;

import java.util.LinkedList;

/**
 * For given BST assign an appropriate value to neighbor of all nodes.
 *
 * Created by akhalikov on 07/03/16
 */
public class TreeNeighbor {

  /**
   * Level-order traversal with marker
   * @param head
   */
  static void fillNeighbor(Node head) {
    LinkedList<Node> q = new LinkedList<>();
    Node marker = new Node("marker");

    q.add(head);
    q.add(marker);

    while (!q.isEmpty()) {
      Node node = q.remove();
      if (node == marker && !q.isEmpty()) {
        q.add(marker);
      } else {
        Node next = !q.isEmpty() ? q.getFirst() : null;
        if (next != marker)
          node.neighbor = next;

        if (node.left != null)
          q.add(node.left);

        if (node.right != null)
          q.add(node.right);
      }
    }
  }

  static class Node {
    String data;
    Node left;
    Node right;
    Node neighbor;

    public Node(String data) {
      this.data = data;
    }

    public Node(String data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
}
