package chapter01.strings;

/**
 * Assume you have a method isSubstring which checks if one word is substring
 * of another. Given two strings, s1 and s2, write code to check if s2 is a
 * rotation of s1 using only one call to isSubstring.
 *
 * Example: waterbottle -> erbottlewat
 */
class RotationCheck {
  /**
   * Checks if s1 is a rotation of s2
   */
  public static boolean isRotation(String s1, String s2) {
    if (s1.length() != s2.length())
      return false;

    return isSubstring(s2, s1 + s1);
  }

  /**
   * Checks if s1 is substring of s2
   */
  static boolean isSubstring(String s1, String s2) {
    return s2.contains(s1);
  }
}
