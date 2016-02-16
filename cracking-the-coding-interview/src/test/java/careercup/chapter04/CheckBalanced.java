package careercup.chapter04;

import algo.tree.Tree;

/**
 * Check if binary tree is balanced.
 * A balanced tree is defined to be a tree such that the heights of the two
 * subtrees of any node never differ by more than one.
 *
 * Brute force algorithm is to check that difference if heights of left and right
 * subtrees of every node is <= 1.
 * This will take O(n log n) and is implemented here: {@link algo.tree.TreeProperties}
 *
 * Let's try to do it O(n)
 *
 * @author akhalikov
 */
public class CheckBalanced {
  static boolean isBalanced(Tree.Node root) {
    return checkHeight(root) != Integer.MIN_VALUE;
  }

  private static int checkHeight(Tree.Node node) {
    if (node == null)
      return -1;

    int leftHeight = checkHeight(node.getLeft());
    if (leftHeight == Integer.MIN_VALUE)
      return Integer.MIN_VALUE;

    int rightHeight = checkHeight(node.getRight());
    if (rightHeight == Integer.MIN_VALUE)
      return Integer.MIN_VALUE;

    int heightDiff = Math.abs(leftHeight - rightHeight);
    if (heightDiff > 1) {
      return Integer.MIN_VALUE;
    } else {
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
}
