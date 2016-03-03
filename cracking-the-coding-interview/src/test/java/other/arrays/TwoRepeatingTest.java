package other.arrays;

import org.junit.Test;

import static careercup.other.arrays.TwoRepeating.printRepeatingPair;
import static careercup.other.arrays.TwoRepeating.printRepeatingPair2;

/**
 * Test for {@link TwoRepeating}
 *
 * Created by akhalikov on 24/01/16
 */
public class TwoRepeatingTest {
  @Test
  public void testPrintRepeatingPair() throws Exception {
    int[] a = {4, 2, 4, 5, 2, 3, 1};
    printRepeatingPair(a, 5);
  }

  @Test
  public void testPrintRepeating() throws Exception {
    int[] a = {4, 2, 4, 5, 2, 3, 1};
    printRepeatingPair2(a, 5);
  }
}