package chapter01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test RotatedMinTest
 */
public class RotatedMinTest {
  @Test
  public void testFind() {
    int[] a1 = {3, 4, 5, 6, 7, 1, 2};
    assertEquals(1, RotatedMin.find(a1));

    int[] a2 = {0, 5, 9};
    assertEquals(0, RotatedMin.find(a2));
  }
}