package careercup.other.strings;

/**
 * Print all strings of length k where the characters are in sorted order.
 *
 * Runtime: O(k c^k), where c is length of alphabet
 *
 * Created by akhalikov on 15/02/16
 */
class PrintSortedStrings {
  private static final int NUM_CHARS = 26;
  private static final int A_NUMVAL = (int)'a';

  private static long stringsCounter = 0;
  private static long inSortedOrderCounter = 0;
  private static long runtimeUpperBound = 0;
  private static long runtime = 0;


  public static void main(String[] args) {
    printSortedStrings(2);
  }

  static void printSortedStrings(int k) {
    initRuntime();

    printSortedStrings(k, "");

    runtimeUpperBound = inSortedOrderCounter * k;
    printRuntime();
  }

  private static void printSortedStrings(int k, String prefix) {
    if (k == 0) {
      if (isInSortedOrder(prefix)) {
        System.out.println(prefix);
        stringsCounter++;
      }
      return;
    }
    for (int i = 0; i < NUM_CHARS; i++) {
      char c = (char) (A_NUMVAL + i);
      printSortedStrings(k - 1, prefix + c);
    }
  }

  /**
   * Runtime: O(k), where k = length(s)
   */
  private static boolean isInSortedOrder(String s) {
    inSortedOrderCounter++;
    for (int i = 1; i < s.length(); i++) {
      runtime += 1;

      int prev = s.charAt(i-1);
      int next = s.charAt(i);
      if (prev > next)
        return false;
    }
    return true;
  }

  private static void initRuntime() {
    stringsCounter = 0;
    inSortedOrderCounter = 0;
    runtimeUpperBound = 0;
    runtime = 0;
  }

  private static void printRuntime() {
    System.out.println("------------------------------------------");
    System.out.println("Printed " + stringsCounter + " strings");
    System.out.println("Runtime upper bound: " + runtimeUpperBound);
    System.out.println("Runtime: " + runtime);
  }
}
