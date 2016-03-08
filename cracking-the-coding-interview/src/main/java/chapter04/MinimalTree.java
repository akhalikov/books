package chapter04;

/**
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 *
 * BST: all left items <= n < right elements
 */
public class MinimalTree {

  static Node createTreeFromArray(int[] a) {
    if (a == null)
      throw new NullPointerException("a is null");
    return createMinTree(a, 0, a.length-1);
  }

  private static Node createMinTree(int[] a, int lo, int hi) {
    if (hi < lo)
      return null;
    int mid = (lo + hi) / 2;
    Node node = new Node(a[mid]);
    node.left = createMinTree(a, lo, mid - 1);
    node.right = createMinTree(a, mid + 1, hi);
    return node;
  }

  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }
  }
}
