package chapter01;

import java.util.Arrays;

/**
 * Given an integer array, output all pairs that sum up to a specific value k.
 */
class ArrayPairSum {

  /**
   * O (n log n) solution
   */
  static int findPairs(int[] arr, int k) {
    if (arr == null)
      throw new IllegalArgumentException("arr is null");
    if (arr.length < 2)
      return 0;
    Arrays.sort(arr);
    int i = 0,
      j = arr.length - 1,
      pairsNum = 0;
    while (i < j) {
      int sum = arr[i] + arr[j];
      if (sum == k) {
        System.out.println(arr[i] + ", " + arr[j]);
        pairsNum++;
        i++;
        j--;
      } else if (sum > k) j--;
      else i++;
    }
    System.out.println();
    return pairsNum;
  }
}