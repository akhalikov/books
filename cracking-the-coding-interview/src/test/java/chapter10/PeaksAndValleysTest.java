package chapter10;

import static chapter10.PeaksAndValleys.sortPeakValleys;
import org.junit.Test;

import static org.junit.Assert.*;

public class PeaksAndValleysTest {
  @Test
  public void testSortPeakValleys() {
    int[] a = {5, 8, 6, 2, 3, 4, 6};
    int[] expected = {5, 8, 2, 6, 3, 6, 4};
    sortPeakValleys(a);
    assertArrayEquals(expected, a);
  }
}