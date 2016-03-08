package chapter04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, design an algorithm which creates a linked list
 * of all nodes at each depth.
 * E.g. if you have a tree with depth (height) D, you will have D linked lists.
 *
 * @author akhalikov
 */
public class ListOfDepths {
  static List<LinkedList<TreeNode>> getListOfDepths(TreeNode root) {
    final List<LinkedList<TreeNode>> lists = new ArrayList();
    createListForLevel(root, 0, lists);
    return lists;
  }

  static void createListForLevel(TreeNode node, int level,
                                 List<LinkedList<TreeNode>> lists) {
    if (node == null)
      return;

    LinkedList<TreeNode> list;
    if (lists.size() == level) {
      list = new LinkedList();
      lists.add(list);
    } else {
      list = lists.get(level);
    }
    list.add(node);
    createListForLevel(node.left, level + 1, lists);
    createListForLevel(node.right, level + 1, lists);
  }

  public static class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
      this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
}
