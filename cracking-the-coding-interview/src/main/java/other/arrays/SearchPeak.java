package other.arrays;

/**
 * In an array of integers where the numbers go increasingly,
 * and at some point will start decreasing like this:
 * -1 2 3 4 5 6 7 8 4 3 0
 *
 * Created by akhalikov on 05/03/16
 */
public class SearchPeak {
  static int findPeak(int[] arr) {
    return binarySearch(arr, 0, arr.length-1);
  }

  private static int binarySearch(int[] arr, int lo, int hi) {
    if (lo > hi)
      return -1;
    int mid = (lo + hi) / 2;
    if (arr[mid-1] < arr[mid] && arr[mid+1] < arr[mid])
      return mid;
    else if (arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1])
      return binarySearch(arr, mid+1, hi);
    else
      return binarySearch(arr, lo, mid-1);
  }
}
