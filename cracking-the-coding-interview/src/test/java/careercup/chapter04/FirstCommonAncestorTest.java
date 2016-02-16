package careercup.chapter04;

import algo.tree.BinarySearchTree;
import algo.tree.LevelView;
import algo.tree.Tree;
import algo.tree.Tree.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link FirstCommonAncestor}
 *
 * @author akhalikov
 */
public class FirstCommonAncestorTest {

  @Test
  public void testFindWithParent() throws Exception {
    Tree tree = new BinarySearchTree<>(7, 4, 9, 1, 5, 6);
    LevelView.printLevelOrder(tree);

    Node root = tree.getRoot();
    Node n9 = root.getRight();
    Node n4 = root.getLeft();
    Node n5 = n4.getRight();
    Node n6 = n5.getRight();
    Node n1 = n4.getLeft();

    assertEquals(root, FirstCommonAncestor.findWithParent(root, n6));
    assertEquals(root, FirstCommonAncestor.findWithParent(n6, n9));
    assertEquals(n4, FirstCommonAncestor.findWithParent(n1, n6));
  }
}