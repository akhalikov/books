package other.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * There is an array of non-negative integers. A second array is formed by shuffling
 * the elements of the first array and deleting a random element.
 * Given these two arrays, find which element is missing in the second array.
 * See more at: http://www.ardendertat.com/2011/09/27/programming-interview-questions-4-find-missing-element
 *
 * Created by akhalikov on 24/01/16
 */
public class FindMissingNumber {
  /**
   * Hash-table approach
   * Time complexity: O(n), space complexity O(n)
   */
  static int find(int[] a, int[] b) {
    final Map<Integer, Integer> bFrequencyMap = getFrequencyMap(b);
    for (int num: a) {
      if (!bFrequencyMap.containsKey(num))
        return num;
    }
    return -1;
  }

  /**
   * Very clever and tricky approach using XOR operator
   * Time complexity: O(n), space: O(1)
   */
  static int find2(int[] a, int[] b) {
    int missing = 0;
    for (int num: a)
      missing ^= num;
    for (int num: b)
      missing ^= num;
    return missing;
  }

  /**
   * Building frequency map
   * @param a array
   * @return Map
   */
  static Map<Integer, Integer> getFrequencyMap(int[] a) {
    final Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num: a) {
      if (frequencyMap.containsKey(num))
        frequencyMap.put(num, frequencyMap.get(num) + 1);
      else
        frequencyMap.put(num, 1);
    }
    return frequencyMap;
  }

  public static void main(String[] args) {
    xorExample();
  }

  /**
   * See how XOR works
   * For more, check out https://stackoverflow.com/questions/1991380/what-does-the-operator-do-in-java
   */
  static void xorExample() {
    int a = 0;
    a ^= 9; // 9 is our missing number
    System.out.println(a);
    a ^= 3;
    System.out.println(a);
    a ^= 81;
    System.out.println(a);
    a ^= 81;
    System.out.println(a);
    a ^= 3;
    System.out.println(a);

    assert a == 9: "a is 9 again";
  }
}
