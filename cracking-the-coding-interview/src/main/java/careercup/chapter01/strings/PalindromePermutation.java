package careercup.chapter01.strings;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * Palindrome is a word or phrase that is the same forwards and backwards.
 * Example:
 *  Input: "Tact Coa"
 *  Output: True (permutations: "taco cat", "atco cta", etc)
 *
 * Questions to interviewer:
 *  - check should be case sensitive or not ?
 *  - spaces and non-alphabetic chars are ignored or not ?
 *  - ASCII or Unicode ?
 *  - Can I use additional buffer ?
 */
public class PalindromePermutation {

  /**
   * Assumptions:
   *  - letter case does not matter
   *  - only check alphabetic characters -> ASCII
   *  - I can use buffer
   *
   * Time complexity O(n)
   * Space complexity: O(n)
   */
  static boolean isPalindromePermutation(String str) {
    if (str == null)
      throw new NullPointerException("str is null");
    if (str.length() == 0)
      return false;
    int[] charFrequencyTable = countCharFrequency(str);
    return checkMaxOneOdd(charFrequencyTable);
  }

  /**
   * Time & space complexity: O(1)
   */
  static boolean checkMaxOneOdd(int[] table) {
    boolean foundOdd = false;
    for (int count: table) {
      if (count % 2 > 0) {
        if (foundOdd) {
          return false;
        }
        foundOdd = true;
      }
    }
    return true;
  }

  /**
   * Time & space complexity: O(n)
   */
  static int[] countCharFrequency(String str) {
    int n = getSize('a', 'z');
    int[] arr = new int[n];
    for (char c: str.toCharArray()) {
      int val = getCharNumber(c);
      if (val > 0) arr[val]++;
    }
    return arr;
  }

  /**
   * Time & space complexity: O(1)
   */
  static int getCharNumber(char c) {
    int a = Character.getNumericValue('a');
    int z = Character.getNumericValue('z');
    int A = Character.getNumericValue('A');
    int Z = Character.getNumericValue('Z');
    int val = Character.getNumericValue(c);
    if (a <= val && val >= z)
      return val - a;
    else if (A <= val && val >= Z)
      return val - A;
    else
      return -1;
  }

  static int getSize(char cMin, char cMax) {
    return Character.getNumericValue(cMax) - Character.getNumericValue(cMin);
  }
}
