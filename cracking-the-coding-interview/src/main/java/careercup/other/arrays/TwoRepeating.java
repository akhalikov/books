package careercup.other.arrays;

/**
 * Find two repeating numbers in array of n+2 elements,
 * with each element from 1 to n.
 *
 * Created by akhalikov on 24/01/16
 */
public class TwoRepeating {
  /**
   * Time complexity: O(n), space: O(1)
   */
  static void printRepeatingPair(int[] a, int n) {
    // sum of elements and product of elements
    int s = 0, p = 1;
    for (int val: a) {
      s += val;
      p *= val;
    }

    // sum of elements - arithmetic sum
    int ds = s - (1 + n) * n / 2;
    // product of elements / product(1..n)
    int dp = p / fact(n);

    // equations
    // x + y = ds, x*y = dp => x - y = sqrt ((x + y)^2 - 4xy ) = d
    int d = (int) Math.sqrt(ds * ds - 4*dp);

    // x = (ds + d)/2, y = (ds - d) / 2
    int x = (ds + d) / 2;
    int y = (ds - d) / 2;

    System.out.println(x + " " + y);
  }

  /**
   * Time complexity: O(n), space: O(n)
   */
  static void printRepeatingPair2(int[] a, int n) {
    boolean[] seen = new boolean[n+1];
    for (int i = 0; i < a.length; i++) {
      int num = a[i];
      if (seen[num])
        System.out.print(a[i] + " ");
      else
        seen[num] = true;
    }
  }

  static int fact(int n) {
    int i = 1, p = 1;
    while (i <= n) {
      p = p * i;
      i++;
    }
    return p;
  }
}
