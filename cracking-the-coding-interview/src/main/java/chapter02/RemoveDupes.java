package chapter02;

import java.util.HashSet;

/**
 * Write code to remove duplicates from an unsorted linked list (single-linked list).
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
class RemoveDupes {
  /**
   * Solution using hash-table to track duplicate elements
   * Runtime: O(n), memory: O(n)
   */
  static void removeDupes(ListNode head) {
    if (head == null || head.next == null)
      return;
    ListNode curr = head.next, prev = head;
    HashSet<Integer> seen = new HashSet<>();
    while (curr != null) {
      if (seen.contains(curr.data)) {
        // removing duplicate element
        prev.next = curr.next;
        curr.next = null;
      } else {
        seen.add(curr.data);
      }
      prev = curr;
      curr = curr.next;
    }
  }

  /**
   * Solution without additional buffer
   * Runtime - O(n^2), memory - O(1)
   */
  static void removeDupes2(ListNode head) {
    if (head == null || head.next == null)
      return;
    ListNode curr = head;
    while (curr != null) {
      ListNode runner = curr;
      while (runner.next != null) {
        if (runner.next.data == curr.data) {
          runner.next = runner.next.next;
        } else {
          runner = runner.next;
        }
      }
      curr = curr.next;
    }
  }
}
