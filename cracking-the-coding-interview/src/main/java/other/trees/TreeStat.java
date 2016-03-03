package other.trees;

import algo.queue.LinkedQueue;
import algo.queue.Queue;

/**
 * 1. For binary tree with integer data, count the number
 *    of nodes whose value is lower that the value of its upper nodes.
 *
 * 2. Given a binary tree, write a function calculates
 *    sum of values at odd height minus sum of values at even height.
 *
 * 3. Find multiplication of sums of data of leaves at same levels.
 *    {@see http://www.geeksforgeeks.org/find-multiplication-of-sums-of-data-of-all-leaves-at-sane-levels}
 *
 * @author akhalikov
 */
public class TreeStat {
  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }

    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  /**
   * Task 1: number of nodes whose value is lower that the value of its upper nodes.
   * Solution: level-order traversal, O(n)
   */
  static int countLowerNodes(Node root) {
    final Queue<Node> q = new LinkedQueue<>();
    q.add(root);
    int count = 0, min = root.data;
    while (!q.isEmpty()) {
      Node p = q.remove();
      if (p.left != null) {
        if (p.left.data < min) {
          count++;
          min = p.left.data;
        }
        q.add(p.left);
      }
      if (p.right != null) {
        if (p.right.data < min) {
          min = p.right.data;
          count++;
        }
        q.add(p.right);
      }
    }
    return count;
  }
}
