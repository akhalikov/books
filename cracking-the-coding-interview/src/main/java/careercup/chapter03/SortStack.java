package careercup.chapter03;

import algo.stack.LinkedStack;
import algo.stack.Stack;

/**
 * Write a program to sort a stack so that smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy elements into
 * any other data structure.
 * The stack supports the following operations: push, pop, peek, isEmpty
 */
public class SortStack {
  /**
   * Time complexity: O(n^2)
   * Space complexity: O(n)
   * @param stack
   * @return sorted stack
   */
  static Stack<Integer> sort(Stack<Integer> stack) {
    Stack<Integer> sorted = new LinkedStack<>();
    while (!stack.isEmpty()) {
      int tmp = stack.pop();
      while (!sorted.isEmpty() && sorted.peek() < tmp)
        stack.push(sorted.pop());
      sorted.push(tmp);
    }
    return sorted;
  }
}
