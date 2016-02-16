package careercup.other.arrays;

/**
 * Given an array of integers find the element for which the sum of left = sum of right.
 * Example input: -1 100 1 98 1
 * Output: 2 - which is index of 1 in input array
 *
 * @author ahalikov
 */
class SymmetricArrayPivot {

  static int findPivot(int[] a) {
    if (a == null || a.length == 0) return -1;
    int lo = 0, hi = a.length - 1;
    int lsum = a[lo], rsum = a[hi];

    while (lo < hi) {
      if (lsum == rsum) {
        if (lo + 2 == hi) return lo + 1;
      } else if (lsum < rsum) {
        lsum += a[++lo];
      } else {
        rsum += a[--hi];
      }
    }
    return -1;
  }
}
