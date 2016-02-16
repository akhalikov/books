package careercup.other.arrays;

/**
 * Given an array:
 *
 *  [a1, a2, ..., aN, b1, b2, ..., bN, c1, c2, ..., cN]
 *
 * convert it to:
 *
 *  [a1, b1, c1, a2, b2, c2, ..., aN, bN, cN]
 *
 * Created by akhalikov on 24/01/16
 */
public class ConvertArray {

  /**
   * Brute-force solution that takes O(n) space,
   * but does not change the input array.
   *
   * Time complexity: O(n)
   */
  static String[] convert(String[] a) {
    if (a == null)
      return null;
    int len = a.length, n = len / 3, k;
    // create new array
    String[] c = new String[len];
    for (int i = 0; i < n; i++) {
      k = 3*i;
      c[k] = a[i];
      c[k+1] = a[n+i];
      c[k+2] = a[2*n+i];
    }
    return c;
  }

  /**
   * In-place solution
   *
   * Space complexity: O(1)
   * Time complexity: O(n^1.3)
   */
  static void convertInPlace(String[] a) {
    if (a == null)
      return;

    int n = a.length / 3;

    for (int i = 0; i < a.length; i++) {
      int swapIndex = getIndex(i, n);

      while (swapIndex < i)
        swapIndex = getIndex(swapIndex, n);

      swap(a, i, swapIndex);
    }
  }

  private static int getIndex(int currentIndex, int n) {
    return (currentIndex % 3) * n + currentIndex/3;
  }

  private static void swap(String[] a, int i, int j) {
    String tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
