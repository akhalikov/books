package chapter10;

import java.util.BitSet;

/**
 * You have an array with all the numbers from 1..N, where N <= 32.000.
 * The array have duplicate entries and you do not know what N is.
 * With only 4 Kb of memory available,
 * how would you print all duplicate elements in the array ?
 *
 * 4kb = 32,768 bits
 * integer = 4 bytes = 32 bits
 * Q: How many integers do I need to index numbers <= 32,000 ?
 * A: 32000 / 32 = 1000
 *
 * Created by artur on 20.01.16.
 */
public class FindDuplicates {
  static final int N = 32000;

  static void printDuplicates(int[] arr) {
    algo.structures.BitSet bs = new algo.structures.BitSet(N);
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      int val0 = val - 1; // numbers start from 1, bitset starts from 0
      if (bs.get(val0))
        System.out.print(val + " ");
      else
        bs.set(val0);
    }
    System.out.println();
  }

  /**
   * Using java.util.BitSet
   * @param arr
   */
  static void printDuplicates2(int[] arr) {
    BitSet bs = new BitSet();
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      int val0 = val - 1; // numbers start from 1, bitset starts from 0
      if (bs.get(val0))
        System.out.print(val + " ");
      else
        bs.set(val0);
    }
    System.out.println();
  }
}
