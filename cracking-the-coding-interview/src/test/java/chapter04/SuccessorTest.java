package chapter04;

import algo.tree.BinarySearchTree;
import algo.tree.LevelView;
import static algo.tree.LevelView.printLevelOrder;
import algo.tree.Tree;
import algo.tree.Tree.Node;
import static chapter04.Successor.getNextNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SuccessorTest {
  @Test
  public void testGetNextNode() throws Exception {
    Tree tree = new BinarySearchTree<>(7, 4, 9, 1, 5, 6);
    printLevelOrder(tree);

    Node root = tree.getRoot();
    Node n9 = root.getRight();
    Node n4 = root.getLeft();
    Node n5 = n4.getRight();
    Node n6 = n5.getRight();
    Node n1 = n4.getLeft();

    assertEquals("7 (root) -> 9", n9, getNextNode(root));
    assertEquals("4 -> 5", n5, getNextNode(n4));
    assertEquals("5 -> 6", n6, getNextNode(n5));
    assertEquals("6 -> 7 (root)", root, getNextNode(n6));
    assertEquals("1 -> 4", n4, getNextNode(n1));
    assertEquals("9 -> null", null, getNextNode(n9));
  }
}