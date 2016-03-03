package other.arrays;

/**
 * Given an array of integers (positive and negative) find the largest continuous sum.
 *
 * Created by akhalikov on 24/01/16
 */
public class MaxContiguousSum {
  /**
   * Largest contiguous sum via Kadane's algorithm
   * extended with tracking of start end end indexes of the largest sum.
   * @param a input array
   * @return LCS
   */
  static MaxSum find(int[] a) {
    checkNotEmpty(a);

    int currentSum = a[0], maxSum = currentSum;
    int start = 0, tempStart = 0, end = 0;

    for (int i = 1; i < a.length; i++) {
      if (a[i] > currentSum + a[i]) {
        tempStart = i; // new sum started
        currentSum = a[i];
      } else
        currentSum += a[i];

      if (currentSum > maxSum) {
        maxSum = currentSum;
        start = tempStart;
        end = i;
      }
    }
    return new MaxSum(maxSum, start, end);
  }

  /**
   * Kadane's algorithms without tracking of start/end
   * @param a
   * @return
   */
  static int find0(int[] a) {
    checkNotEmpty(a);
    int maxSum = a[0], currentSum = maxSum;
    for (int num: a) {
      currentSum = Math.max(num, currentSum + num);
      maxSum = Math.max(maxSum, currentSum);
    }
    return maxSum;
  }

  static void checkNotEmpty(int[] a) {
    if (a == null || a.length == 0)
      throw new IllegalArgumentException("a is null or empty");
  }

  static class MaxSum {
    int sum;
    int start, end;

    public MaxSum(int sum, int start, int end) {
      this.sum = sum;
      this.start = start;
      this.end = end;
    }
  }
}
