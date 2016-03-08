package chapter01.strings;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 *
 * Questions to interviewer:
 * - is there any information about string: is it alphabetic, ASCII or Unicode string ?
 * - for alphabetic string: are letters in one case (lower/upper), or not ?
 * - are we allowed to modify the input string ?
 * - memory restrictions ?
 *
 * @author akhalikov
 */
class UniqueChars {
  /**
   * ASCII string with additional buffer
   * Time complexity: O(n)
   * Space complexity: O(1)
   */
  static boolean isUniqueASCIIChars(String str) {
    if (str == null || str.isEmpty())
      throw new IllegalArgumentException("str is null or empty");

    // Ony char is unique
    if (str.length() == 1)
      return true;

    // ASCII has only 256 characters
    if (str.length() > 256)
      return false;

    boolean charSet[] = new boolean[256];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (charSet[val]) {
        return false;
      }
      charSet[val] = true;
    }
    return true;
  }

  /**
   * Alphabetic lower-cased string w/o additional buffer - using bit vector
   */
  static boolean isUniqueAlphaLowercasedChars(String str) {
    if (str == null || str.isEmpty())
      throw new IllegalArgumentException("str is null or empty");

    // Ony char is unique
    if (str.length() == 1)
      return true;

    // There are 26 letters in alphabet
    if (str.length() > 26)
      return false;

    int checker = 0;
    for (int i = 0; i < str.length(); ++i) {
      int val = str.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) return false;
      checker |= (1 << val);
    }
    return true;
  }

  /**
   * Alphabetic string w/o additional buffer - using bit vector,
   * case insensitive
   */
  static boolean isUniqueAlphaChars(String str) {
    if (str == null || str.isEmpty())
      throw new IllegalArgumentException("str is null or empty");

    // Ony char is unique
    if (str.length() == 1)
      return true;

    // 26 in lower case + 26 in upper case
    if (str.length() > 26*2)
      return false;

    long checker = 0;
    long one = 1;
    for (int i = 0; i < str.length(); ++i) {
      int val = numValue(str.charAt(i));
      if ((checker & (one << val)) > 0) return false;
      checker |= (one << val);
    }
    return true;
  }

  private static int numValue(char c) {
    int a = 'a', z = 'z', A = 'A', Z = 'Z';
    int val = c;
    if (a <= val && val <= z)
      return val - 'a';
    else if (A <= val && val <= Z)
      return val - 'A' + 32;
    else
      throw new IllegalArgumentException("Invalid char: " + c);
  }
}
