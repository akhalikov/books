package careercup.chapter04;

import algo.tree.Tree.Node;

/**
 * Implement a function to check if a tree is balanced in O(n)

 * Def: tree is said to be balanced if
 * (1) it is empty, or
 * (2) its left and right children are height-balanced and the height of the
 * left tree is within 1 of the height of the right tree.
 */
class TreeBalanceCheck {
  static boolean isBalanced(Node root) {
    return findAndCheckHeight(root) != Integer.MIN_VALUE;
  }

  static int findAndCheckHeight(Node root) {
    if (root == null)
      return -1; // terminate if tree is empty and return -1

    int leftHeight = findAndCheckHeight(root.getLeft());
    if (leftHeight == Integer.MIN_VALUE)
      return Integer.MIN_VALUE;

    int rightHeight = findAndCheckHeight(root.getRight());
    if (rightHeight == Integer.MIN_VALUE)
      return Integer.MIN_VALUE;

    int heightDiff = Math.abs(leftHeight - rightHeight);
    if (heightDiff > 1)
        return Integer.MIN_VALUE;

    return Math.max(leftHeight, rightHeight) + 1;
  }
}
