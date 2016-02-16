package careercup.chapter04;

import algo.tree.Tree.Node;

/**
 * Find first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure.
 * The tree is not necessary a BST.
 *
 * Questions:
 *  - do I have link to parents ? If not, I need to know the root.
 *
 *  So there are two cases:
 *    1. with links to parents
 *    2. without links to parents, with root
 *
 * @author akhalikov
 */
public class FirstCommonAncestor {
  /**
   * Assuming we have links to parents
   * @param a
   * @param b
   * @return
   */
  static Node findWithParent(Node a, Node b) {
    int levelA = findLevel(a);
    int levelB = findLevel(b);
    int levelDiff = Math.abs(levelA - levelB);
    Node startNode1 = a, startNode2 = b;
    if (levelA < levelB) {
      // Node a is upper than b
      startNode2 = getParentLevelsUp(b, levelDiff);
    } else if (levelA > levelB) {
      // Node a is lower than b
      startNode1 = getParentLevelsUp(a, levelDiff);
    }
    // so now we have 2 nodes on the same level
    // there are two cases:
    //  (1) they're equal -> we've got it
    if (startNode1 == startNode2)
      return startNode1;

    //  (2) not equal -> we need to go up level by level
    Node p = startNode1.getParent();
    Node q = startNode2.getParent();
    while (p != q && p != null && q != null) {
      p = p.getParent();
      q = q.getParent();
    }
    // we need to check if p and q are not nulls
    return (p == null || q == null) ? null: p;
  }

  private static int findLevel(Node n) {
    int level = 0;
    while (n.getParent() != null) {
      n = n.getParent();
      level++;
    }
    return level;
  }

  private static Node getParentLevelsUp(Node n, int numLevels) {
    while (numLevels > 0) {
      n = n.getParent();
      numLevels--;
    }
    return n;
  }
}
