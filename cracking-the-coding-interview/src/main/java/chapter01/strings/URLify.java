package chapter01.strings;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * Questions to interviewer:
 *  - do I have a enough space at the end of the string (for in-place modifications) ?
 *  - do I know the real length of the string ?
 *
 * @author akhalikov
 */
public class URLify {

  /**
   * Assumptions:
   *  - there is enough buffer at the end of the string
   *  - in-place modification is allowed
   *  - real length of the string is given
   *
   *  Time complexity: O(n)
   *  Space complexity: O(n) - because of in-place modification
   */
  static char[] replaceSpaces(char[] str, int len) {
    if (len == 0)
      return str;
    int k = str.length - 1;
    for (int i = len - 1; i >= 0; i--) {
      if (str[i] != ' ') {
        str[k--] = str[i];
      } else {
        str[k--] = '0';
        str[k--] = '2';
        str[k--] = '%';
      }
    }
    return str;
  }
}
