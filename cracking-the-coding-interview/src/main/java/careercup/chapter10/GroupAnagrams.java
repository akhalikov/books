package careercup.chapter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Write a method to sort an array of strings,
 * so that all the anagrams are next to each other.
 *
 * @author ahalikov
 */
class GroupAnagrams {
  /**
   * Time complexity: O(n log n)
   * @param arr Array of strings
   */
  static void sort(String[] arr) {
    Arrays.sort(arr,
      (String s1, String s2) -> sortChars(s1).compareTo(sortChars(s2)));
  }

  /**
   * Time complexity: O(n+k), where k is amount of anagrams
   * Space complexity: O(n)
   * @param arr
   */
  static void sort2(final String[] arr) {
    final HashMap<String, List<String>> anagrams = new HashMap<>();
    for (String s: arr) {
      String sorted = sortChars(s);
      if (anagrams.get(sorted) != null) {
        anagrams.get(sorted).add(s);
      } else {
        List bucket = new ArrayList();
        bucket.add(s);
        anagrams.put(sorted, bucket);
      }
    }
    int index = 0;
    for (String key: anagrams.keySet()) {
      List<String> list = anagrams.get(key);
      for (String s: list)
        arr[index++] = s;
    }
  }

  private static String sortChars(String s) {
    char[] chars = s.toLowerCase().toCharArray();
    Arrays.sort(chars);
    return String.valueOf(chars);
  }
}
