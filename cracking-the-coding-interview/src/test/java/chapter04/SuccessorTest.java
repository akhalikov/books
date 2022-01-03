package chapter04;

import algo.tree.BinarySearchTree;
import org.junit.Test;

import static algo.tree.LevelView.printLevelOrder;
import static chapter04.Successor.getNextNode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SuccessorTest {

    @Test
    public void testGetNextNode() throws Exception {
        var tree = new BinarySearchTree<>(7, 4, 9, 1, 5, 6);
        printLevelOrder(tree);

        var root = tree.getRoot();
        var n9 = root.getRight();
        var n4 = root.getLeft();
        var n5 = n4.getRight();
        var n6 = n5.getRight();
        var n1 = n4.getLeft();

        assertEquals("7 (root) -> 9", n9, getNextNode(root));
        assertEquals("4 -> 5", n5, getNextNode(n4));
        assertEquals("5 -> 6", n6, getNextNode(n5));
        assertEquals("6 -> 7 (root)", root, getNextNode(n6));
        assertEquals("1 -> 4", n4, getNextNode(n1));
        assertNull("9 -> null", getNextNode(n9));
    }
}