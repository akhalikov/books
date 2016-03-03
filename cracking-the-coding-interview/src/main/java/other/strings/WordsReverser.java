package other.strings;

import java.util.LinkedList;

/**
 * Given an input string, reverse all the words.
 * Input: "Interviews are awesome!"
 * Output: "awesome! are Interviews"
 *
 * Created by akhalikov on 25/01/16
 */
public class WordsReverser {
  /**
   * Simple approach using String.split() function and StringBuilder
   * Time complexity: O(n)
   * Space complexity: O(n)
   */
  static String reverse(String text) {
    if (text == null)
      throw new NullPointerException("s is null");

    // Split sentence into array of words
    String[] words = text.split(" ");
    int n = words.length;
    if (n < 2)
      return text;

    StringBuilder sb = new StringBuilder(n);
    // Iterate the array from end to start
    for (int i = n - 1; i >=0; i--) {
      if (words[i].length() != 0) {
        if (sb.length() != 0)
          sb.append(" ");
        sb.append(words[i]);
      }
    }
    return sb.toString();
  }

  /**
   * Let's try without String.split() function but using Stack
   * Same complexity as in previous approach
   */
  static String reverse2(String text) {
    if (text == null)
      throw new NullPointerException("s is null");

    LinkedList<String> stack = new LinkedList<>();
    int index = 0, wordStart = 0;
    int len = text.length();
    if (len < 2)
      return text;

    // Iterate the string and move index until space is found
    while (index < len) {
      if (text.charAt(index) != ' ') {
        wordStart = index;
        while (index < len && text.charAt(index) != ' ')
          index++;
        stack.addFirst(text.substring(wordStart, index));
      }
      index++;
    }
    if (stack.size() == 0)
      return text;

    StringBuilder sb = new StringBuilder(stack.size());
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
      if (!stack.isEmpty())
        sb.append(" ");
    }
    return sb.toString();
  }

  /**
   * In-place approach can be used only with C-style string
   */
  static void reverse3(char[] text) {
    if (text == null)
      throw new NullPointerException("s is null");
    if (text.length < 2)
      return;
    reverse(text, 0, text.length - 1, 0);
    int read = 0, write = 0, wordStart;
    while (read < text.length) {
      if (text[read] != ' ') {
        wordStart = read;
        for (; read < text.length && text[read] != ' '; read++);
        reverse(text, wordStart, read - 1, write);
        write += read - wordStart;
        if (write < text.length)
          text[write++] = ' ';
      }
      read++;
    }
  }

  static void reverse(char[] text, int start, int end, int dest) {
    int len = end - start + 1;
    System.arraycopy(text, start, text, dest, len);
    for (int i = 0; i < len/2; i++)
      swap(text, dest + i, dest + len - 1 - i);
  }

  static void swap(char[] arr, int i, int j) {
    char tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
