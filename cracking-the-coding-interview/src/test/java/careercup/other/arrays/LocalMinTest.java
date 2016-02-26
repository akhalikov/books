package careercup.other.arrays;

import static junit.framework.Assert.*;
import org.junit.Test;

/**
 * Test LocalMinTest
 */
public class LocalMinTest {
  @Test
  public void testFindMin() {
    int[] numbers = {5, 2, 8, 8, 7, 7, 7, 8};
    assertEquals(1, LocalMin.find(numbers));
  }
}