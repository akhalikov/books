package other.arrays;

/**
 * Given an array of 0s and 1s - find the index of a zero
 * turning which into 1 will produce a longest continuous 1s.
 *
 * Input: 1, 1, 0, 0, 1, 1, 1, 0, 1, 1
 * Output: 6 (flipping 0 at index 7 will produce 6-length sequence of 1s)
 *
 * http://www.geeksforgeeks.org/find-index-0-replaced-1-get-longest-continuous-sequence-1s-binary-array/
 *
 * Created by akhalikov on 06/03/16
 */
public class MaxContinuousSequence {
  /**
   * Brute-force O(n^2) solution
   * @param arr
   * @return length of the max continuous sequence of 1s
   */
  static int findMaxContinuous(int[] arr) {
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        int tempMax = 0;
        if (i > 0 && arr[i-1] == 1) {
          int j = i - 1;
          while (j >= 0 && arr[j--] == 1)
            tempMax++;
        }

        if (i < arr.length-1 && arr[i+1] == 1) {
          int j = i + 1;
          while (j < arr.length && arr[j++] == 1)
            tempMax++;
        }
        if (tempMax > max)
          max = tempMax;
      }
    }
    return max+1;
  }

  /**
   * Optimized solution that runs for O(n)
   * @param arr
   * @return
   */
  static int maxOnesIndex(int[] arr) {
    int n = arr.length,
        maxCount = 0,
        maxIndex = 0,
        prevZero  = -1,
        prevPrevZero = -1;

    for (int i = 0; i < n; i++) {
      // if current element is 0, then calculate the difference
      // between curr and prevPrevZero
      if (arr[i] == 0) {
        if (i - prevPrevZero > maxCount) {
          maxCount = i - prevPrevZero;
          maxIndex = prevZero;
        }

        // Update for the next iteration
        prevPrevZero = prevZero;
        prevZero = i;
      }
    }

    // Check for the last encountered zero
    if (n - prevPrevZero > maxCount)
      maxIndex = prevZero;

    return maxIndex;
  }
}
