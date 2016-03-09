package chapter08;

/**
 * Write a recursive function to multiply two positive integers
 * without using the * operator.
 * You can use +, -, and bit shifting,
 * but you should minimise the number of those operations.
 *
 * Created by akhalikov on 08/03/16
 */
public class RecursiveMultiply {
  /**
   * Brute-force approach
   * Time complexity O(n)
   * @param a number
   * @param n times
   * @return a * n
   */
  static int mul(int a, int n) {
    if (n == 1)
      return a;
    else
      return a + mul(a, n-1);
  }
}
