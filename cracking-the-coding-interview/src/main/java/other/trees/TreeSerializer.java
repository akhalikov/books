package other.trees;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/**
 * Given a binary tree, serialize the tree and store it as a file,
 * and retrieve it back to the form of a binary tree.
 *
 * Created by akhalikov on 05/03/16
 */
public class TreeSerializer {

  static void serialize(TreeNode root, String filePath) {
    Path path = Paths.get(filePath);
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
      serialize(root, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static TreeNode deserialize(String str) {
    final StringTokenizer st = new StringTokenizer(str, " ");
    return deserialize(st);
  }

  private static TreeNode deserialize(StringTokenizer st) {
    if (!st.hasMoreTokens())
      return null;
    String val = st.nextToken();
    if (val.equals("#"))
      return null;
    TreeNode node = new TreeNode(Integer.parseInt(val));
    node.left = deserialize(st);
    node.right = deserialize(st);
    return node;
  }

  private static void serialize(TreeNode node,
                                BufferedWriter writer) throws IOException {
    if (node == null) {
      writer.append("# ");
      return;
    }
    writer.append(node.data + " ");
    serialize(node.left, writer);
    serialize(node.right, writer);
  }

  public static void main(String[] args) throws Exception {
    TreeNode root = new TreeNode(12,
      new TreeNode(8, new TreeNode(5), new TreeNode(9)),
      new TreeNode(19, null, new TreeNode(25)));
    serialize(root, "tree.txt");

    String serial = new String(Files.readAllBytes(Paths.get("tree.txt")));
    TreeNode tree = deserialize(serial);
  }

  static class TreeNode {
    int data;
    TreeNode left, right;

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
