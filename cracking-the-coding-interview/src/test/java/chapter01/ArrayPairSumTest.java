package chapter01;

import org.junit.Test;

import static org.junit.Assert.*;
import static chapter01.ArrayPairSum.*;

/**
 * @author ahalikov
 */
public class ArrayPairSumTest {
  @Test(expected = IllegalArgumentException.class)
  public void testFindPairsCornerCase1() {
    assertEquals(0, findPairs(null, 10));
  }

  @Test
  public void testFindPairsCornerCase2() {
    assertEquals(0, findPairs(new int[]{1}, 10));
  }

  @Test
  public void testFindPairs() throws Exception {
    assertEquals(0, findPairs(new int[]{1, 2, 3}, 10));
    assertEquals(4, findPairs(new int[]{3, 8, 2, 5, 1, 4, 7, 6, 0, 10, -5}, 5));
    assertEquals(2, findPairs(new int[]{2, 4, 6, 8, 10}, 10));
    assertEquals(1, findPairs(new int[]{12, 15, 20, 22, 34, 36}, 27));
  }
}