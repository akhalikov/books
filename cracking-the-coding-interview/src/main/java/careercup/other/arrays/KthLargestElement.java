package careercup.other.arrays;

import algo.ArrayPartition;

import java.util.Random;

/**
 * Given an array of integers find the kth element in the sorted order
 * (not the kth distinct element).
 *
 * So, if the array is [3, 1, 2, 1, 4] and k is 3 then the result is 2,
 * because it’s the 3rd element in sorted order (but the 3rd distinct element is 3).
 *
 * Created by akhalikov on 06/02/16
 */
public class KthLargestElement {
  private static final Random rand = new Random();

  /**
   * 3 1 2 1 4, k=3
   *
   * Approach: partition with pivot = a[k-1]
   * Time complexity: O(n), space: O(1)
   *
   * 2 1 3 1 4
   * 2 1 1 3 4
   * 1 1 2 3 4
   *
   * @param a array of integers
   * @return kth element in a sorted order
   */
  public static int find(int[] a, int k) {
    if (a == null)
      throw new IllegalArgumentException("arr is null");

    return find(a, 0, a.length, k);
  }

  private static int find(int[] a, int left, int right, int k) {
    if (!(left <= k && k <= right))
      throw new IllegalArgumentException("k is out of bounds");

    if (left == right)
      return a[left];

    int pivotIndex, rank;
    while (true) {
      pivotIndex = rand.nextInt(right);
      pivotIndex = ArrayPartition.partition(a, left, right, pivotIndex);
      rank = pivotIndex - left + 1;
      if (rank == k)
        return a[pivotIndex];
      else if (k < rank)
        return find(a, left, pivotIndex-1, k);
      else
        return find(a, pivotIndex+1, right, k-rank);
    }
  }
}
