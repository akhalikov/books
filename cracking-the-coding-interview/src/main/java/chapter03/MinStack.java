package chapter03;

import algo.stack.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * How would you design a stack which, in addition to push and pop,
 * also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 *
 * The first idea was to store index pointed to minimum element.
 * It did not work because after pop() method this index did not changed and still pointed
 * to old min. To fix that pop() should set index to new min. element, which is O(n).
 */
public class MinStack<E> implements Stack<E> {

  private List<E> elements = new ArrayList();
  private int minIndex = -1;

  @Override
  public E pop() {
    int last = elements.size() - 1;
    if (last >= 0) {
      E item = elements.get(last);
      elements.remove(last);
      return item;
    }
    return null;
  }

  @Override
  public void push(E item) {
    if (item == null)
      throw new NullPointerException("Cannot add null");

    elements.add(item);
    if (minIndex < 0) {
      minIndex = 0;
    } else {
      Comparable comp = (Comparable) item;
      if (comp.compareTo(elements.get(minIndex)) < 0) {
        minIndex = elements.size() - 1;
      }
    }
  }

  public E min() {
    return (minIndex >= 0)
      ? elements.get(minIndex) : null;
  }

  @Override
  public E peek() {
    int last = elements.size() - 1;
    return elements.get(last);
  }

  @Override
  public boolean isEmpty() {
    return elements.size() == 0;
  }
}
