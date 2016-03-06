package careercup.chapter16;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Given any integer, print an English phrase that describes the integer
 * For example: 1234 = One Thousand Two Hundred Thirty Four
 *
 * Questions:
 *  - how about negative numbers ?
 *
 * 001,234
 * 100,030,000
 *
 * 1 chunk: none
 * 2 chunks: thousand
 * 3 chunks: million
 * 4 chunks: billion
 *
 * Created by akhalikov on 05/03/16
 */
public class EnglishInt {
  private static final String negative = "minus";
  private static final String[] smalls = {
    "zero", "one", "two", "three", "four", "five",
    "six", "seven", "eight", "nine", "ten",
    "eleven", "twelve", "thirteen", "fourteen", "fifteen",
    "sixteen", "seventeen", "eighteen", "nineteen"
  };
  private static final String[] tens = {
    "", "", "twenty", "thirty", "forty", "fifty",
    "sixty", "seventy", "eighty", "ninety"
  };
  private static final String hundred = "hundred";
  private static final String[] bigs = {"", "thousand", "million", "billion"};

  static String intToPhrase(int num) {
    if (num == 0)
      return smalls[0];

    if (num < 0)
      return negative + " " + convert((-1) * num);

    return convert(num);
  }

  private static String convert(int num) {
    LinkedList<String> parts = new LinkedList<>();
    int chunkNum = 0;
    while (num > 0) {
      if (num % 1000 > 0) {
        String chunk = convertChunk(num % 1000)
          + (chunkNum > 0 ? " " + bigs[chunkNum] : "");
        parts.addFirst(chunk);
      }
      num /= 1000;
      chunkNum++;
    }
    return listToString(parts);
  }

  private static String convertChunk(int num) {
    LinkedList<String> parts = new LinkedList<>();
    if (num >= 100) {
      parts.addLast(smalls[num / 100]);
      parts.add(hundred);
      num %= 100;
    }
    if (num >= 20) {
      parts.addLast(tens[num / 10]);
      parts.addLast(smalls[num % 10]);
    } else {
      parts.addLast(smalls[num]);
    }
    return listToString(parts);
  }

  private static String listToString(LinkedList<String> parts) {
    Iterator<String> iter = parts.listIterator();
    String str = "";
    while (iter.hasNext())
      str += iter.next() + (iter.hasNext() ? " " : "");
    return str;
  }
}
