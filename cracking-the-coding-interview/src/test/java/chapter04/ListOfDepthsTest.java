package chapter04;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link ListOfDepths}
 * 
 * @author akhalikov
 */
public class ListOfDepthsTest {
  @Test
  public void testGetListOfDepths() throws Exception {
    TreeNode n6 = new TreeNode(6, new TreeNode(7), null);
    TreeNode n3 = new TreeNode(2, n6, null);
    TreeNode n2 = new TreeNode(5, new TreeNode(1), new TreeNode(4));
    TreeNode root = new TreeNode(3, n2, n3);

    List<LinkedList<TreeNode>> list = ListOfDepths.getListOfDepths(root);
    LinkedList<TreeNode> l0 = list.get(0);
    assertEquals(3, l0.getFirst().data);

    LinkedList<TreeNode> l1 = list.get(1);
    assertEquals(5, l1.get(0).data);
    assertEquals(2, l1.get(1).data);

    LinkedList<TreeNode> l2 = list.get(2);
    assertEquals(1, l2.get(0).data);
    assertEquals(4, l2.get(1).data);
    assertEquals(6, l2.get(2).data);

    LinkedList<TreeNode> l3 = list.get(3);
    assertEquals(7, l3.get(0).data);
  }
}