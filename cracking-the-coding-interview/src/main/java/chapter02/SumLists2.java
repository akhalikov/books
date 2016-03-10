package chapter02;

/**
 * More optimal approach to {@link SumLists} to the first case of reversed lists
 *
 * @author akhalikov
 */
public class SumLists2 {

  /**
   * Time complexity: O(n)
   * Spce complexity: O(n) (stack recursion)
   * @param p List 1
   * @param q List 2
   * @return Sum of lists
   */
  static ListNode sum(ListNode p, ListNode q) {
    return sumRec(p, q, 0);
  }

  /**
   * Recursive calculation of sum of lists
   * @param p Node
   * @param q Node
   * @param carry
   * @return Node
   */
  private static ListNode sumRec(ListNode p, ListNode q, int carry) {
    if (p == null && q == null && carry == 0) // base case
      return null;

    int s = carry
      + (p != null ? p.data: 0)
      + (q != null ? q.data: 0);

    carry = s / 10;
    ListNode sum = new ListNode(s % 10, null);
    sum.next = sumRec(
      p != null ? p.next : null,
      q != null ? q.next : null,
      carry);

    return sum;
  }
}
