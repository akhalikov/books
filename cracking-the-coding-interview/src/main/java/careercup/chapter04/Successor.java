package careercup.chapter04;

import algo.tree.Tree.Node;

/**
 * Find the next node (in-order successor) of a given node in a BST.
 * Each node has link to it's parent.
 *
 * Given node: n
 * Let's define successor as:
 *  if hasRightChild(n): leftmost node int the right subtree
 *  else:
 *    let p be parent of n
 *    if n to the left of p: it is parent of p
 *    else:
 *      let q be parent of p
 *      go up with q and p until p is not to the left of q: return q
 *
 * @author akhalikov
 */
public class Successor {
  static Node getNextNode(Node node) {
    if (node == null)
      return null;

    if (node.getRight() != null) {
      return getLeftmostNode(node.getRight());
    } else {
      Node p = node.getParent();
      if (p.getLeft() == node) {
        return p;
      } else {
        Node q = p.getParent();
        while (p != null && q != null && q.getLeft() != p) {
          p = q;
          q = q.getParent();
        }
        return q;
      }
    }
  }

  private static Node getLeftmostNode(Node n) {
    if (n == null)
      return null;
    while (n.getLeft() != null)
      n = n.getLeft();
    return n;
  }
}
