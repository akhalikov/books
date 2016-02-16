package careercup.chapter03;

import algo.stack.LinkedStack;
import algo.stack.Stack;

/**
 * Another approach to {@link MinStack}:
 *
 * How would you design a minStack which, in addition to push and pop,
 * also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 *
 * Design:
 *
 *  - MinStack class inherits from LinkedStack
 *  - min elements are tracked by another minStack
 *
 * @author akhalikov
 */
public class MinStack2 extends LinkedStack<Integer> {
  /**
   * Internal stack to keep track of minimum elements
   */
  private Stack<Integer> minStack = new LinkedStack();

  /**
   * Return minimum element of a minStack
   */
  public Integer min() {
    return minStack.isEmpty() ? Integer.MAX_VALUE: minStack.peek();
  }

  @Override
  public void push(Integer value) {
    if (value < minStack.peek()) {
      minStack.push(value);
    }
    super.push(value);
  }

  @Override
  public Integer pop() {
    Integer value = super.pop();
    if (value == minStack.peek()) {
      minStack.pop();
    }
    return value;
  }
}
