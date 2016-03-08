package chapter10;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times,
 * write code to find an element in the array.
 * You may assume that the array was originally sorted in increasing order.
 *
 * @author ahalikov
 */
public class SearchRotatedArray {
  /**
   * Time complexity: O(log n)
   * @param a array of integers
   * @param x number to search
   * @return index of element if found, otherwise -1
   */
  static int search(int[] a, int x) {
    if (a == null)
      throw new NullPointerException("array is null");
    if (a.length == 0)
      return -1;
    return search(a, 0, a.length-1, x);
  }

  static int search(int[] a, int lo, int hi, int x) {
    if (hi < lo)
      return -1;

    int mid = (lo + hi) / 2;
    if (x == a[mid])
      return mid;

    if (a[lo] < a[mid]) {
      // search left part
      if (x >= a[lo] && x < a[mid])
        return search(a, lo, mid - 1, x);
      else
        return search(a, mid + 1, hi, x);
    } else if (a[mid] < a[lo]) {
      // search right part
      if (a[mid] < x && x <= a[hi])
        return search(a, mid + 1, hi, x);
      else
        return search(a, lo, mid - 1, x);
    } else if (a[lo] == a[mid]) {
      if (a[mid] != a[hi])
        return search(a, mid + 1, hi, x);
      else {
        // search both left and right parts
        int index = search(a, lo, mid - 1, x);
        if (index == -1)
          return search(a, mid + 1, hi, x);
        else
          return index;
      }
    }
    return -1;
  }
}
