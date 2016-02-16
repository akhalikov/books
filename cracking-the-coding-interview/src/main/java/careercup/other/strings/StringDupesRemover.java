package careercup.other.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer. NOTE: One or two additional variables are fine.
 * An extra copy of the array is not.
 * FOLLOW UP
 * Write the test cases for this method.
 *
 * Created by akhalikov on 24/04/15.
 */
public class StringDupesRemover {
  /**
   * Solution uses additional buffer to store unique characters
   * Should work for ASCII characters
   * Time complexity: O(N), where N = length(str)
   */
  public static String removeDupes(String str) {
    if (str == null)
      throw new IllegalArgumentException("str is null");
    if (str.length() < 2)
      return str;

    StringBuilder sb = new StringBuilder();
    int checker = 0B0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) == 0)
        sb.append(str.charAt(i));

      checker |= (1 << val);
    }
    return sb.toString();
  }

  /**
   * Solution for ASCII characters using boolean array
   * to keep track of duplicate characters
   * Time complexity: O(N), where N = length(str)
   */
  public static String removeDupes2(String str) {
    if (str == null)
      throw new IllegalArgumentException("str is null");
    if (str.length() < 2)
      return str;

    boolean[] seen = new boolean[128];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (!seen[val]) {
        sb.append(str.charAt(i));
        seen[val] = true;
      }
    }
    return sb.toString();
  }

  /**
   * Solution for Unicode strings using Set to keep track of duplicate characters
   * Time complexity: O(N), where N = length(str)
   */
  public static String removeDupes3(String str) {
    if (str == null)
      throw new IllegalArgumentException("str is null");
    if (str.length() < 2)
      return str;
    Set seen = new HashSet<Character>();
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (!seen.contains(c)) {
        sb.append(c);
        seen.add(c);
      }
    }
    return sb.toString();
  }

  /**
   * O(n^2) inplace solution for character array
   */
  public static char[] removeDupes4(char[] s) {
    if (s == null || s.length < 2) return s;
    for (int i = 1; i < s.length; i++) {
      int j;
      for (j = 0; j < i; j++) {
        if (s[i] == s[j]) s[i] = 0;
      }
    }
    return s;
  }
}
