package chapter01.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Design an algorithm to print all permutations of a string.
 * For simplicity, assume all characters are unique.
 *
 * Follow up 1: What if input string has duplicate characters ?
 * To eliminate duplicates, I use Set data structure.
 *
 * Follow up 2: Count all combinations of all sub-lengths
 *
 * @author akhalikov
 */
class Permutations {
  private static Set<String> perms;

  public static Set<String> find(String s) {
    perms = new HashSet<>();
    permutation("", s);
    return perms;
  }

  private static void permutation(String left, String right) {
    int n = right.length();
    if (n == 0)
      perms.add(left);
    else {
      for (int i = 0; i < n; i++)
        permutation(left + right.charAt(i),
          right.substring(0, i) + right.substring(i + 1));
    }
  }
}
