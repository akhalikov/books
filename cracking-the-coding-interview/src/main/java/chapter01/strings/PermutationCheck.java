package chapter01.strings;

import static java.util.Arrays.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 * Permutation = Anagram
 *
 * Questions to interviewer:
 *
 * What is permutation ? (just to confirm that you and interviewer on the same line)
 *  - Each of several possible ways in which a set characters can be reordered.
 *    Permutations of abc: {abc, bca, bac, cab, cba, acb}
 *
 * 1. WHat is the size of character set - ASCII or Unicode ?
 * 2. Is it case-sensitive permutation ?
 * 3. Does string contains all unique characters ?
 * 4. Can I assume that input strings are not nulls ?
 * 5. Are there any restrictions: memory or time ?
 *
 */
class PermutationCheck {
  /**
   * Assumptions: charset is unicode, case sensitive, non-null args
   * Solve the problem using sorting with:
   *
   * Time: O(n log(n)), space: O(n)
   */
  static boolean isPermutation(String str1, String str2) {
    return str1 != null
      && str2 != null
      && str1.length() == str2.length()
      && sortStr(str1).equals(sortStr(str2));
  }

  /**
   * Assumptions:
   *  - unicode charset
   *  - case sensitive
   *  - non-null args
   *
   * Time = O(n), space = O(n)
   */
  static boolean isPermutation2(String str1, String str2) {
    if (str1 == null || str2 == null
      || str1.length() != str2.length()) {
      return false;
    }
    final Map<Character, Integer> charMap = new HashMap<>();
    for (char c: str1.toCharArray()) {
      charMap.put(c, getCharCount(charMap, c));
    }
    for (char c: str2.toCharArray()) {
      if (!charMap.containsKey(c) || charMap.get(c) < 0) {
        return false;
      }
      charMap.put(c, charMap.get(c)-1);
    }
    return true;
  }

  private static int getCharCount(Map<Character, Integer> charMap, char c) {
    return charMap.get(c) != null ? charMap.get(c) + 1 : 1;
  }

  /**
   * Assumptions: ASCII charset, case-sensitive (!), non-null args
   * abbc = {1,2,1,0}
   * abcd = {1,1,1,1}
   * Time = O(n), space = O(n)
   */
  static boolean isPermutation3(String str1, String str2) {
    if (str1 == null || str2 == null
      || str1.length() != str2.length()) {
      return false;
    }
    int[] letters = new int[256];
    for (char c: str1.toCharArray()) {
      letters[c]++;
    }
    for (char c: str2.toCharArray()) {
      letters[c]--;
      if (letters[c] < 0) {
        return false;
      }
    }
    return true;
  }

  private static String sortStr(String s) {
    char[] chars = s.toCharArray();
    sort(chars);
    return new String(chars);
  }
}
