package careercup.chapter02;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 *
 * Example #1
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2)
 * That is, 617 + 295
 *
 * Output: 2 -> 1 -> 9
 *
 * Follow up: suppose the digits are stored in forward order. Repeat the above problem.
 *
 * Example #2
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5)
 * That is, 617 + 295
 *
 * Output: 9 -> 1 -> 2, That is, 912
 */
class SumLists {
  static class Node {
    int data;
    Node next;

    public Node() {
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  /**
   * Brute-force solution to the first case of reversed lists
   * Time complexity: O(n^2)
   * @param p Node
   * @param q Node
   * @return Node
   */
  static Node sum(Node p, Node q) {
    long x = toNumber(p);
    long y = toNumber(q);
    return toList(x + y);
  }

  /**
   * Time complexity: O(n^2)
   * @param node
   * @return
   */
  private static long toNumber(Node node) {
    long num = 0;
    int factor = 0;
    while (node != null) {
      num += node.data * pow10(factor++);
      node = node.next;
    }
    return num;
  }

  /**
   * Time complexity: O(n^2)
   * @param num
   */
  private static Node toList(long num) {
    Node head = new Node();
    Node node = head;
    while (num > 0) {
      long digit = num >= 10 ? num % 10 : num;
      num = num / 10;
      node.data = (int) digit;
      if (num > 0) {
        node.next = new Node();
        node = node.next;
      }
    }
    return head;
  }

  /**
   * Time complexity: O(n)
   * @param times
   */
  private static long pow10(int times) {
    long n = 1;
    while (times > 0) {
      n = n * 10;
      times--;
    }
    return n;
  }
}
