package careercup.chapter10;

/**
 * In an array of integers, a "peak" is an element which is greater than or equal to
 * the adjacent integers and a "valley" is an element which is less than or equal to
 * the adjacent integers.
 *
 * For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks, and {5,2} are valleys.
 * Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
 *
 * Created by artur on 20.01.16.
 */
public class PeaksAndValleys {
  static void sortPeakValleys(int[] array) {
    if (array == null)
      throw new NullPointerException("array is null");
    if (array.length < 3)
      return;

    for (int i = 1; i < array.length; i+=2) {
      int maxIndex = getMaxIndex(array, i-1, i, i+1);
      if (i != maxIndex)
        swap(array, i, maxIndex);
    }
  }

  private static int getMaxIndex(int[] a, int lo, int mid, int hi) {
    int loVal = (lo >= 0 && lo < a.length) ? a[lo]: Integer.MIN_VALUE;
    int midVal = (mid >= 0 && mid < a.length) ? a[mid]: Integer.MIN_VALUE;
    int hiVal = (hi >= 0 && hi < a.length) ? a[hi]: Integer.MIN_VALUE;

    int maxVal = Math.max(loVal, Math.max(midVal, hiVal));
    if (maxVal == loVal) return lo;
    else if (maxVal == midVal) return mid;
    else return hi;
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
