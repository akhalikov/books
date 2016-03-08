package chapter10;

/**
 * Given a sorted array of strings that is interspersed with empty strings,
 * write a method to find the location of a given string.
 *
 * Example
 *
 * Input: ball, {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 * Output: 4
 *
 * Created by artur on 20.01.16.
 */
public class SearchSparceArray {
  static int search(String[] arr, String x) {
    if (arr == null)
      throw new NullPointerException("arr is null");
    if (x == null)
      throw new NullPointerException("x is null");
    if (arr.length == 0)
      return -1;
    return search(arr, 0, arr.length-1, x);
  }

  private static int search(String[] arr, int lo, int hi, String x) {
    int mid = (lo + hi) / 2;
    if (hi < lo)
      return -1;

    if ("".equals(arr[mid])) {
      mid = shiftMid(arr, lo, mid, hi);
      if (mid == -1)
        return -1;
    }
    if (x.equals(arr[mid]))
      return mid;
    else if (x.compareTo(arr[mid]) < 0)
      return search(arr, 0, mid - 1, x);
    else
      return search(arr, mid + 1, hi, x);
  }

  private static int shiftMid(String[] arr, int lo, int mid, int hi) {
    int left = mid - 1, right = mid + 1;
    while (true) {
      if (left < lo && right > hi)
        return -1;
      else if (left >= lo && !"".equals(arr[left])) {
        mid = left;
        break;
      }
      else if (right <= hi && !"".equals(arr[right])) {
        mid = right;
        break;
      } else {
        left--;
        right++;
      }
    }
    return mid;
  }
}
