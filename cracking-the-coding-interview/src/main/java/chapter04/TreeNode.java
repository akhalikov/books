package chapter04;

class TreeNode {
  int data;
  TreeNode left;
  TreeNode right;

  TreeNode(int data) {
    this.data = data;
  }

  TreeNode(int data, TreeNode left, TreeNode right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
}
