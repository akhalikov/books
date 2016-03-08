package chapter04;

import algo.tree.Tree;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link CheckBalanced}
 *
 * @author akhalikov
 */
public class CheckBalancedTest {
  @Test
  public void testIsBalanced() throws Exception {
    Tree.Node<Integer> tree1 = new Tree.Node(7,
      new Tree.Node(4,
        new Tree.Node(1), new Tree.Node(6)),
      new Tree.Node(9)
    );
    assertTrue(CheckBalanced.isBalanced(tree1));

    Tree.Node<Integer> tree2 = new Tree.Node(7,
      new Tree.Node(4,
        new Tree.Node(1), new Tree.Node(6, new Tree.Node(8, new Tree.Node(10), null), null)),
      new Tree.Node(9)
    );
    assertFalse(CheckBalanced.isBalanced(tree2));
  }
}