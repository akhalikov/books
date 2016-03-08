package chapter01.strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link PalindromePermutation}
 *
 * @author akhalikov
 */
public class PalindromePermutationTest {
  @Test
  public void testIsPalindromePermutation() throws Exception {
    assertTrue("baba", PalindromePermutation.isPalindromePermutation("baba"));
    assertTrue("babaY", PalindromePermutation.isPalindromePermutation("babaY"));
    assertTrue("Tact Coa", PalindromePermutation.isPalindromePermutation("Tact Coa"));
    assertFalse("empty string", PalindromePermutation.isPalindromePermutation(""));
  }

  @Test
  public void testIsPalindromePermutation2() throws Exception {
    assertTrue("baba", PalindromePermutation2.isPalindromePermutation("baba"));
    assertTrue("babaY", PalindromePermutation2.isPalindromePermutation("babaY"));
    assertTrue("Tact Coa", PalindromePermutation2.isPalindromePermutation("Tact Coa"));
    assertFalse("empty string", PalindromePermutation2.isPalindromePermutation(""));
  }

  @Test
  public void testGetCharNumber() throws Exception {
    //assertEquals(Character.getNumericValue('a'), (int)'a');
    //assertEquals(Character.getNumericValue('z'), (int)'z');
    //assertEquals(Character.getNumericValue('A'), (int)'A');
    //assertEquals(Character.getNumericValue('A'), (int)'Z');
  }
}