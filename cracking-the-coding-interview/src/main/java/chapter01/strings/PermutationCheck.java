package chapter01.strings;

import java.util.Arrays;
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
    if (str1.length() != str2.length())
      return false;
    char[] chars1 = str1.toCharArray();
    char[] chars2 = str2.toCharArray();
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    return Arrays.equals(chars1, chars2);
  }

  /**
   * Assumptions: unicode charset, case sensitive, non-null args, time complexity <= O(n);
   * Solve the problem making count of characters in HashMap
   *
   * Time = O(n), space = O(n)
   */
  static boolean isPermutation2(String str1, String str2) {
    if (str1.length() != str2.length())
      return false;

    // count 1st string
    final Map<Character, Integer> charMap1 = new HashMap<>();
    for (char c: str1.toCharArray()) {
      charMap1.put(c, getCharCount(charMap1, c));
    }

    // count 2nd string
    final Map<Character, Integer> charMap2 = new HashMap<>();
    for (char c: str2.toCharArray()) {
      charMap2.put(c, getCharCount(charMap2, c));
    }

    // compare character counts
    for (Map.Entry<Character, Integer> entry: charMap1.entrySet()) {
      if (charMap2.get(entry.getKey()) != entry.getValue())
        return false;
    }
    return true;
  }

  private static int getCharCount(Map<Character, Integer> charMap, char c) {
    return charMap.get(c) != null ? charMap.get(c)+1 : 1;
  }

  /**
   * Assumptions: ASCII charset, case-sensitive (!), non-null args
   * abbc = {1,2,1,0}
   * abcd = {1,1,1,1}
   * Time = O(n), space = O(n)
   */
  static boolean isPermutation3(String str1, String str2) {
    if (str1.length() != str2.length())
      return false;

    // count letters in str1
    int[] letters = new int[256];
    for (char c: str1.toCharArray()) {
      letters[c]++;
    }

    // subtract count(str1) - count(str2)
    for (char c: str2.toCharArray()) {
      letters[c]--;
      if (letters[c] < 0)
        return false;
    }
    return true;
  }
}
