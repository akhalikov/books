package other.arrays;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Test for {@link MaxContinuousSequence}
 */
public class MaxContinuousSequenceTest {
  @Test
  public void testFindLength() {
    int[] arr = {1, 1, 0, 0, 1, 1, 1, 0, 1, 1};
    assertEquals(6, MaxContinuousSequence.findMaxContinuous(arr));
  }

  @Test
  public void testMaxOnesIndex() {
    int[] arr = {1, 1, 0, 0, 1, 1, 1, 0, 1, 1};
    assertEquals(7, MaxContinuousSequence.maxOnesIndex(arr));

    arr = new int[] {1, 0, 1, 1, 0, 0, 1, 1};
    assertEquals(1, MaxContinuousSequence.maxOnesIndex(arr));
  }
}