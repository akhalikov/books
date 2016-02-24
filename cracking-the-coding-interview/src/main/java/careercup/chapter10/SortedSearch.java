package careercup.chapter10;

/**
 * You are given an array-like data structure Listy which lacks a size method.
 * It does, however, have an elementAt(i) method that returns the element at index i in O(1) time.
 * If it is beyond the bounds of the data structure, it returns -1.
 * (For this reason, the data structure only supports positive integers).
 *
 * Given a Listy which contains sorted, positive integers,
 * find the index at which an element x occurs.
 * If x occurs multiple times, you may return any index.
 *
 * Information that we have:
 *  1) numbers in Listy are sorted so when we trying to guess the length, we
 *      can also check if number at index i is less than searched value
 *  2) binary search can not be applied directly because we don't know the size
 *
 * Created by artur on 20.01.16.
 */
public class SortedSearch {

  int find(Listy listy, int value) {
    int index = 1;
    while (listy.elementAt(index) > 0 && listy.elementAt(index) > value)
      index *= 2;

    return binarySeach(listy, value, 0, index);
  }

  /**
   * Modified binary search
   */
  static int binarySeach(Listy listy, int value,
                         int fromIndex, int toIndex) {
    int low = fromIndex,
       high = toIndex;
    while (low <= high) {
      int midIndex = (low + high) >>> 1;
      int midVal = listy.elementAt(midIndex);
      if (midVal == value)
        return midIndex;
      else if (midVal < 0 || value < midVal)
        return binarySeach(listy, value, fromIndex, midIndex-1);
      else if (midVal)
    }
  }

  static class Listy {
    private int[] data;

    public Listy(int[] data) {
      this.data = data;
    }

    public int elementAt(int index) {
      if (index < 0 || index >= data.length)
        return -1;
      return data[index];
    }
  }
}
