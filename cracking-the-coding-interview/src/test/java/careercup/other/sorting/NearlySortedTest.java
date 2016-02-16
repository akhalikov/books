package careercup.other.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Test for {@link NearlySorted}
 *
 * Created by akhalikov on 24/01/16
 */
public class NearlySortedTest {
  @Test
  public void testSortK() throws Exception {
    int[] a = {1, 0, 6, 4, 2, 7, 19, 8, 33};
    int[] expected = {1, 0, 6, 4, 2, 7, 19, 8, 33};
    Arrays.sort(expected);

    NearlySorted.sortK(a, 2);
    assertArrayEquals(expected, a);
  }

  @Test
  public void testName() throws Exception {
    int[] a = {2, 6, 3, 12, 56, 8};
    int[] expected = {2, 6, 3, 12, 56, 8};
    Arrays.sort(expected);

    NearlySorted.sortK(a, 3);
    assertArrayEquals(expected, a);
  }
}