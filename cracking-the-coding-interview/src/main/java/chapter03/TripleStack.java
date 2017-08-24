package chapter03;

/**
 * Implement three stacks using a single array
 */
class TripleStack<E> {
  private static final int INITIAL_CAPACITY = 30;

  private Object[] elements;

  // todo: this data can be moved to class StackInfo
  private final int[] headIndex = new int[4];
  private final int[] bottomIndex = new int[4];

  TripleStack() {
    elements = new Object[INITIAL_CAPACITY];
  }

  /**
   * Push to stack #stackId
   */
  void push(E item, int stackId) {
    if (stackId > 1)
      initNextStackIfEmpty(stackId);

    checkIfStackIsFull(stackId);
    elements[headIndex[stackId]++] = item;
  }

  /**
   * Pop from stack #stackId
   */
  E pop(int stackId) {
    if (isEmpty(stackId))
      throw new RuntimeException("Stack " + stackId + " is empty");

    E item = (E) elements[headIndex[stackId]-1];
    elements[--headIndex[stackId]] = null;
    freeStackIfEmpty(stackId);
    return item;
  }

  E peek(int stackId) {
    if (isEmpty(stackId))
      throw new RuntimeException("Stack " + stackId + " is empty");

    return (E) elements[headIndex[stackId] - 1];
  }

  boolean isEmpty(int stackId) {
    return headIndex[stackId] == bottomIndex[stackId];
  }

  // todo: this methods can be moved to class StackInfo
  private void initNextStackIfEmpty(int stackId) {
    final int countReserved = 10;
    if (headIndex[stackId] == 0) {
      headIndex[stackId] = headIndex[stackId - 1] + countReserved;
      bottomIndex[stackId] = headIndex[stackId];
    }
  }

  private void checkIfStackIsFull(int stackId) {
    final int nextStackBottom = (stackId < 3)
      ? bottomIndex[stackId + 1] : elements.length;
    if (nextStackBottom > 0 && headIndex[stackId] >= nextStackBottom)
      throw new RuntimeException("Stack " + stackId + " is full");
  }

  private void freeStackIfEmpty(int stackId) {
    if (isEmpty(stackId) && stackId > 1) {
      headIndex[stackId] = 0;
      bottomIndex[stackId] = 0;
    }
  }
}
