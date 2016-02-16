package careercup.chapter01.strings;

/**
 * Basic string compression using the counts of repeated characters:
 * aabccccaaa -> a2b1c4a3
 *
 * If the compressed string would not become smaller than original string,
 * return the original string.
 *
 * String has only uppercase and lowercase letters.
 *
 * @author akhalikov
 */
public class BasicCompression {

  static String compress(String str) {
    if (str == null)
      throw new NullPointerException("str is null");
    if (str.length() == 0)
      return str;

    StringBuilder compressed = new StringBuilder();
    int countRepeated = 0;
    for (int i = 0; i < str.length(); i++) {
      countRepeated++;
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
        compressed.append(str.charAt(i));
        compressed.append(countRepeated);
        countRepeated = 0;
      }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
  }
}
