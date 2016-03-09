package chapter08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Write a method to compute all the permutations of a string
 * whose characters are not necessarily unique.
 * The list of permutations should not have duplicates.
 *
 * Created by akhalikov on 08/03/16
 */
public class PermutationsWithDupes {
  /**
   * Worst time complexity: O(n!)
   *
   * Solution is optimized to not generate duplicate permutations
   */
  static Set<String> getPermutations(String str) {
    final Set<String> perms = new HashSet<>();
    final Map<Character, Integer> freqMap = buildFreqMap(str);

    genPerms("", str.length(), freqMap, perms);

    return perms;
  }

  private static void genPerms(String prefix, int remains,
                               Map<Character, Integer> freqMap,
                               Set<String> perms) {
    if (remains == 0)
      perms.add(prefix);
    else {
      for (char c: freqMap.keySet()) {
        int count = freqMap.get(c);
        if (count > 0) {
          freqMap.put(c, count-1);
          String before = prefix + c;
          genPerms(before, remains-1, freqMap, perms);
          freqMap.put(c, count);
        }
      }
    }
  }

  private static Map<Character, Integer> buildFreqMap(String str) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c: str.toCharArray())
      if (freqMap.containsKey(c))
        freqMap.put(c, freqMap.get(c)+1);
      else
        freqMap.put(c, 1);
    return freqMap;
  }
}
