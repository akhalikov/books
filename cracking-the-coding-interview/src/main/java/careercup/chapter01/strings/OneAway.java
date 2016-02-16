package careercup.chapter01.strings;

/**
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * 3 types of edits: insert, remove, or replace a character.
 *
 * @author akhalikov
 */
public class OneAway {

  /**
   * Time and space complexity: O(n)
   */
  static boolean isOneAway(String s1, String s2) {
    if (Math.abs(s1.length() - s2.length()) > 1)
      return false;

    int editsCount = 0, index1 = 0, index2 = 0;
    while (index1 < s1.length() && index2 < s2.length()) {
     if (s1.charAt(index1) != s2.charAt(index2)) {
       editsCount++;
       if (s1.length() > s2.length()) index1++;
       else if (s1.length() < s2.length()) index2++;
       else {
         index1++;
         index2++;
       }
     } else {
       index1++;
       index2++;
     }
    }
    return editsCount <= 1;
  }

  /**
   * Solution from Gayle Laakmann's book
   * Time and space complexity: O(n)
   */
  static boolean isOneAway2(String first, String second) {
    if (Math.abs(first.length() - second.length()) > 1)
      return false;

    // Let's define shorter and longer string
    String s1 = first.length() < second.length() ? first : second;
    String s2 = first.length() < second.length() ? second : first;

    int index1 = 0, index2 = 0;
    boolean foundDiff = false;
    while (index1 < s1.length() && index2 < s2.length()) {
      if (s1.charAt(index1) != s2.charAt(index2)) {
        if (foundDiff)
          return false;
        foundDiff = true;

        if (s1.length() == s2.length())
          index1++;
      } else {
        index1++;
      }
      index2++;
    }
    return true;
  }
}
