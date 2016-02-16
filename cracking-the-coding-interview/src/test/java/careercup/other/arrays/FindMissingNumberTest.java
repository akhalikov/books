package careercup.other.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link FindMissingNumber}
 *
 * Created by akhalikov on 24/01/16
 */
public class FindMissingNumberTest {
  @Test
  public void testFind() throws Exception {
    int[] a = {4, 1, 0, 2, 9, 6, 8, 7, 5, 3};
    int[] b = {6, 4, 7, 2, 1, 0, 8, 3, 9};
    assertEquals(5, FindMissingNumber.find(a, b));
  }

  @Test
  public void testFind2() throws Exception {
    int[] a = {4, 1, 0, 2, 9, 6, 8, 7, 5, 3};
    int[] b = {6, 4, 7, 2, 1, 0, 8, 3, 9};
    assertEquals(5, FindMissingNumber.find2(a, b));
  }
}