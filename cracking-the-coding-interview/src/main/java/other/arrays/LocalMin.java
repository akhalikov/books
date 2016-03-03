package other.arrays;

/**
 * Find any local min in an array
 */
public class LocalMin {
  /**
   * Returns position of any local minimum in an array
   * or -1 if local minimum is not found.
   *
   * QA:
   *  How local min is defined ?
   *  a[i] is local min if a[i-1] <= a[i] <= a[i+1]
   *
   * Example:
   * Input:  array = {5, 2, 8, 8, 7, 7, 7, 8}
   * Output: 1, array[1] = 2 or 4, 5, 6
   *
   * Corner cases:
   *  - array is sorted increasingly, and all elements are distinct: 2, 3, 4, 5, 6, 7, 8, 9
   *  - array is sorted decreasingly, and all elements are distinct: 9, 8, 7, 6, 5, 4, 3, 2
   *  - array has all equal elements: 2, 2, 2, 2, 2, 2
   *
   * Algorithm: modified binary search
   *
   * @return int
   */
  static int find(int[] array) {
    if (array == null)
      throw new NullPointerException("array is null");
    if (array.length == 0)
      return -1;
    if (array.length == 1)
      return array[0];
    if (array.length == 2)
      return array[0] <= array[1] ? array[0]: array[1];

    return binarySearch(array, 0, array.length - 1);
  }

  static int binarySearch(int[] array, int low, int hi) {
    int mid = (low + hi) / 2;
    // Compare middle element with its neighbours (if neighbours exist)
    if ((mid == 0 ||  array[mid] <= array[mid-1])
      && (mid == hi || array[mid] <= array[mid+1]))
      return mid;
    else if (mid > 0 && array[mid-1] < array[mid])
      return binarySearch(array, low, mid - 1);
    else
      return binarySearch(array, mid + 1, low);
  }
}
