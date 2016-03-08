package chapter08;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link MagicIndex}
 */
public class MagicIndexTest {
  @Test
  public void testFind() {
    int[] arr = {0};
    assertEquals(0, MagicIndex.findMagicIndex(arr));

    arr = new int[]{-40, -20, -1, 1, 2, 3, 5, 8, 9, 12, 13};
    assertEquals(-1, MagicIndex.findMagicIndex(arr));

    arr = new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
    assertEquals(7, MagicIndex.findMagicIndex(arr));
  }
}