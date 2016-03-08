package chapter01;

/**
 * A sorted array has been rotated so that the elements might appear in the
 * order 3 4 5 6 7 1 2.
 * How would you find the minimum element?
 */
class RotatedMin {
  static int find(int[] sorted) {
    int lo = 0, hi = sorted.length, mid = 0;
    int first = sorted[lo];
    while (hi - lo > 1) {
      mid = (lo + hi) / 2;
      int midVal = sorted[mid];
      if (midVal > first)
        lo = mid + 1;
      else
        hi = mid;
    }
    return (sorted[mid] < first) ? sorted[mid] : first;
  }
}
