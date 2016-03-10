package chapter02;

import algo.stack.LinkedStack;
import algo.stack.Stack;

/**
 * Implement a function to check if a linked list is a palindrome.
 *
 * Assumptions:
 *  - singly-linked list
 *
 * @author akhalikov
 */
public class CheckPalindrome {
  /**
   * Algorithm:
   *  - push first half into stack
   *  - compare second part of a list with values from stack
   *
   * Time complexity: O(n)
   * Space complexity: O(n)
   *
   * @param head List
   * @return true if LL is palindrome
   */
  static boolean isPalindrome(ListNode head) {
    if (head == null)
      throw new NullPointerException("List is null");
    Stack<Integer> stack = new LinkedStack<>();
    ListNode n = head;
    int len = getLength(head),
        mid = len / 2,
        i = 0;
    while (n != null) {
      // pushing first half into stack
      if (i < mid)
        stack.push(n.data);
      else if (i > mid) {
        // compare second half with stack values
        if (stack.pop() != n.data)
          return false;
      }
      n = n.next;
    }
    return true;
  }

  /**
   * Small enhancement to the approach above:
   *  one list traversal via getLength() is removed
   * @param head ListNode
   * @return true if LL is palindrome
   */
  static boolean isPalindrome2(ListNode head) {
    if (head == null)
      throw new NullPointerException("List is null");

    Stack<Integer> stack = new LinkedStack<>();
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      stack.push(slow.data);
      slow = slow.next;
      fast = fast.next.next;
    }
    // skip middle item if list has odd number of items
    if (fast != null)
      slow = slow.next;

    // compare the second half with values from stack
    while (slow != null) {
      if (stack.pop() != slow.data)
        return false;
      slow = slow.next;
    }
    return true;
  }

  /**
   * Time/space complexity: O(n)
   * @param head List's head
   * @return Length of the list
   */
  private static int getLength(ListNode head) {
    int len = 0;
    while (head != null) {
      head = head.next;
      len++;
    }
    return len;
  }
}
