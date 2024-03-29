package chapter04;

import static chapter04.MinimalTree.createTreeFromArray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimalTreeTest {

    @Test
    public void testCreateTreeFromArray() {
        var a = new int[]{1, 2, 3, 4, 5, 8, 13, 15};
        var tree = createTreeFromArray(a);
        assertEquals(4, tree.data);

        // left sub-tree
        assertEquals(2, tree.left.data);
        assertEquals(1, tree.left.left.data);
        assertEquals(3, tree.left.right.data);

        // right sub-tree
        assertEquals(8, tree.right.data);
        assertEquals(5, tree.right.left.data);
        assertEquals(13, tree.right.right.data);
        assertEquals(15, tree.right.right.right.data);
    }
}