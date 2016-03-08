package chapter08;

import java.util.Arrays;

/**
 * A child is running up a staircase with n steps and can hop
 * either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child
 * can run up the stairs.
 *
 * Created by akhalikov on 20/02/16
 */
public class TripleStep {
  /**
   * Brute-force solution, running for O(3^n)
   */
  static int countWays(int n) {
    if (n < 0)
      return 0;
    else if (n == 0)
      return 1;
    else
      return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
  }

  /**
   * Iterative solution, running for O(n)
   * Space complexity: O(1)
   *
   * n = 0: prev1 = prev2 = prev3 = 0
   * n = 1: prev1 = 1, prev2 = 0, prev3 = 0
   * n = 2: prev1 = 1, prev2 = 1, prev3 = 0
   */
  static int countWaysIter(int n) {

    if (n == 0)
      return 0;
    else if (n == 1)
      return 1;
    else {
      int prev1 = 1, prev2 = 1, prev3 = 0;
      int count = 0;
      for (int i = 2; i <= n; i++) {
        count = prev1 + prev2 + prev3;
        prev3 = prev2;
        prev2 = prev1;
        prev1 = count;
      }
      return count;
    }
  }

  /**
   * Memoization solution
   */
  static int countWaysMemo(int n) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return countWaysMemo(n, memo);
  }

  static int countWaysMemo(int n, int[] memo) {
    if (n < 0)
      return 0;
    else if (n == 0)
      return 1;
    else if (memo[n] > -1) {
      return memo[n];
    } else {
      memo[n] =
        countWaysMemo(n-1, memo)
        + countWaysMemo(n-2, memo)
        + countWaysMemo(n-3, memo);

      return memo[n];
    }
  }
}
