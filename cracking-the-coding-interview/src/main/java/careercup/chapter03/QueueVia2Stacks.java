package careercup.chapter03;

import algo.queue.Queue;
import algo.stack.LinkedStack;
import algo.stack.Stack;

/**
 * Implement a MyQueue class which implements a queue using 2 stacks.
 *
 * add - O(1)
 * remove - O(n)
 * peek - O(n)
 * isEmpty - O(1)
 *
 * @author akhalikov
 */
public class QueueVia2Stacks<E> implements Queue<E> {
  private Stack<E> newest = new LinkedStack<>();
  private Stack<E> oldest = new LinkedStack<>();

  @Override
  public boolean add(E item) {
    newest.push(item);
    return false;
  }

  @Override
  public E remove() {
    shiftStacks();
    return oldest.pop();
  }

  @Override
  public E peek() {
    shiftStacks();
    return oldest.peek();
  }

  @Override
  public boolean isEmpty() {
    return newest.isEmpty() && oldest.isEmpty();
  }

  /**
   * Lazily shift elements from newest to oldest
   */
  private void shiftStacks() {
    if (oldest.isEmpty()) {
      while (!newest.isEmpty())
        oldest.push(newest.pop());
    }
  }
}
