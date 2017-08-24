package chapter01.strings;

import static chapter01.strings.PalindromePermutation.isPalindromePermutation;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromePermutationTest {
  @Test
  public void testIsPalindromePermutation() throws Exception {
    assertTrue("baba", isPalindromePermutation("baba"));
    assertTrue("babaY", isPalindromePermutation("babaY"));
    assertTrue("Tact Coa", isPalindromePermutation("Tact Coa"));
    assertFalse("empty string", isPalindromePermutation(""));
  }

  @Test
  public void testIsPalindromePermutation2() throws Exception {
    assertTrue("baba", PalindromePermutation2.isPalindromePermutation("baba"));
    assertTrue("babaY", PalindromePermutation2.isPalindromePermutation("babaY"));
    assertTrue("Tact Coa", PalindromePermutation2.isPalindromePermutation("Tact Coa"));
    assertFalse("empty string", PalindromePermutation2.isPalindromePermutation(""));
  }
}