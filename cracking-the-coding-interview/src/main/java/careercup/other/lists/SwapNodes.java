package careercup.other.lists;

/**
 * Given a linked list and two keys in it, swap nodes for two given keys.
 * Nodes should be swapped by changing links. Swapping data of nodes may
 * be expensive in many situations when data contains many fields.
 *
 * It may be assumed that all keys in linked list are distinct.
 *
 * Examples:
 *                 k1      k2
 * Input:  10->15->12->13->20->14, x = 12, y = 20
 *                 k2      k1
 * Output: 10->15->20->13->12->14
 *
 *         k1                  k2
 * Input:  10->15->12->13->20->14, x = 10, y = 14
 *         k2                  k1
 * Output: 14->15->12->13->20->10
 *
 * Input:  10->15->12->13->20->14, x = 12, y = 13
 * Output: 10->15->13->12->20->14
 *
 * 1) find keys: x, prev(x), y, prev(y)
 * 2) prev(x).next = y
 * 3) prev(y).next = x
 * 4) tmp = y.next
 * 4) y.next = x.next
 * 5) x.next = tmp
 *
 * Edge cases:
 *  - Either x or y is head node
 *  - x and y are adjacent
 *
 * Created by akhalikov on 27/02/16
 */
public class SwapNodes {

  static Node swap(Node head, int x, int y) {
    if (x == y)
      return head;

    // find X node
    Node nodeX = head, prevX = null;
    while (nodeX != null && nodeX.key != x) {
      prevX = nodeX;
      nodeX = nodeX.next;
    }

    // find Y node
    Node nodeY = head, prevY = null;
    while (nodeY != null && nodeY.key != y) {
      prevY = nodeY;
      nodeY = nodeY.next;
    }

    // If either X or Y is null, do nothing
    if (nodeX == null || nodeY == null)
      return head;

    // if x is not head
    if (prevX != null)
      prevX.next = nodeY;
    else
      head = nodeY;

    // if y is not head
    if (prevY != null)
      prevY.next = nodeX;
    else
      head = nodeX;

    // swap next pointers
    Node tmp = nodeY.next;
    nodeY.next = nodeX.next;
    nodeX.next = tmp;

    return head;
  }

  static class Node {
    int key;
    Node next;

    public Node(int key) {
      this.key = key;
    }

    public Node(int key, Node next) {
      this.key = key;
      this.next = next;
    }
  }
}
