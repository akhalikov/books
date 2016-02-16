package careercup.chapter01.strings;

/**
 * Small optimization for {@link PalindromePermutation}
 */
public class PalindromePermutation2 {

  /**
   * Assumptions:
   *  - letter case does not matter
   *  - only check alphabetic characters -> ASCII
   *  - I can use buffer
   *
   * Time complexity O(n)
   * Space complexity: O(1)
   */
  static boolean isPalindromePermutation(String str) {
    if (str == null)
      throw new NullPointerException("str is null");
    if (str.length() == 0)
      return false;

    int countOdd = 0;
    int[] table = new int[PalindromePermutation.getSize('a', 'z')];
    for (char c: str.toCharArray()) {
      int val = PalindromePermutation.getCharNumber(c);
      if (val > 0) {
        table[val]++;
        if (table[val] % 2 == 1)
          countOdd++;
        else
          countOdd--;
      }
    }
    return countOdd <= 1;
  }
}
