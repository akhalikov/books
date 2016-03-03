package other.arrays;

/**
 * We are given 3 strings: str1, str2, and str3. Str3 is said to be a shuffle
 * of str1 and str2 if it can be formed by interleaving the characters
 * of str1 and str2 in a way that maintains the left to right ordering
 * of the characters from each string.
 *
 * For example, given str1="abc" and str2="def", str3="dabecf" is a valid shuffle
 * since it preserves the character ordering of the two strings.
 * So, given these 3 strings write a function that detects
 * whether str3 is a valid shuffle of str1 and str2.
 *
 * See more at: http://www.ardendertat.com/2011/10/10/programming-interview-questions-6-combine-two-strings/#sthash.6G2BDnAh.dpuf
 *
 * Created by akhalikov on 24/01/16
 */
public class CombineTwoStrings {

  static boolean isValidShuffle(String str1, String str2, String str3) {
    validateInputArguments(str1, str2, str3);

    // Basic validation that sum of lengths of str1 and str2 should be equal
    // to the length of str3
    if (str1.length() + str2.length() != str3.length())
      return false;

    int index1 = 0, index2 = 0;
    for (int i = 0; i < str3.length(); i++) {
      if (index1 < str1.length() && str3.charAt(i) == str1.charAt(index1))
        index1++;
      else if (index2 < str2.length() && str3.charAt(i) == str2.charAt(index2))
        index2++;
      else
        return false;
    }

    return true;
  }

  private static void validateInputArguments(String str1, String str2, String str3) {
    if (str1 == null)
      throw new IllegalArgumentException("str1 is null");

    if (str2 == null)
      throw new IllegalArgumentException("str2 is null");

    if (str3 == null)
      throw new IllegalArgumentException("str3 is null");
  }
}
