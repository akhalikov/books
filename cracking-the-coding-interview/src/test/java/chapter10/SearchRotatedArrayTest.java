package chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link SearchRotatedArray}
 *
 * @author akhalikov
 */
public class SearchRotatedArrayTest {
  @Test
  public void testSearch() throws Exception {
    int[] a1 = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
    assertEquals("a1", 8, SearchRotatedArray.search(a1, 5));

    int[] a2 = {2, 2, 2, 2, 2, 2, 4, 10, 11, 2};
    assertEquals("a2, 10", 7, SearchRotatedArray.search(a2, 10));
    assertEquals("a2, 2", 4, SearchRotatedArray.search(a2, 2));
  }
}