package chapter04;

import algo.tree.BinarySearchTree;
import algo.tree.LevelView;
import algo.tree.Tree;
import algo.tree.Tree.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Successor}
 *
 * @author akhalikov
 */
public class SuccessorTest {
  @Test
  public void testGetNextNode() throws Exception {
    Tree tree = new BinarySearchTree<>(7, 4, 9, 1, 5, 6);
    LevelView.printLevelOrder(tree);

    Node root = tree.getRoot();
    Node n9 = root.getRight();
    Node n4 = root.getLeft();
    Node n5 = n4.getRight();
    Node n6 = n5.getRight();
    Node n1 = n4.getLeft();

    assertEquals("7 (root) -> 9", n9, Successor.getNextNode(root));
    assertEquals("4 -> 5", n5, Successor.getNextNode(n4));
    assertEquals("5 -> 6", n6, Successor.getNextNode(n5));
    assertEquals("6 -> 7 (root)", root, Successor.getNextNode(n6));
    assertEquals("1 -> 4", n4, Successor.getNextNode(n1));
    assertEquals("9 -> null", null, Successor.getNextNode(n9));
  }
}