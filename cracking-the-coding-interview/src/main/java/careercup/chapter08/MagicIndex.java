package careercup.chapter08;

/**
 * A magic index in an array A is defined to be an index,
 * such that A[i] = i. Given a sorted array of distinct integers,
 * write a method to find a magic index, if it is exist in array A.
 *
 * Created by akhalikov on 29/02/16
 */
public class MagicIndex {

  /**
   * Run-time complexity: O(log n)
   * @param arr
   * @return magic index or -1 if it not exists in array
   */
  static int findMagicIndex(int[] arr) {
    if (arr == null)
      throw new NullPointerException("arr is null");
    return binarySearch(arr, 0, arr.length-1);
  }

  private static int binarySearch(int[] arr, int lo, int hi) {
    if (lo > hi)
      return -1;
    int mid = (lo + hi) >> 1; // divide by 2
    if (arr[mid] == mid)
      return mid;
    else if (arr[mid] < mid)
      return binarySearch(arr, mid+1, hi);
    else
      return binarySearch(arr, lo, mid-1);
  }
}
