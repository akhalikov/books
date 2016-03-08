package chapter01.strings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link PermutationCheck}
 *
 * @author akhalikov
 */
public class PermutationCheckTest {
  @Test
  public void testIsPermutation() throws Exception {
    assertTrue(PermutationCheck.isPermutation("abc", "bca"));
    assertTrue(PermutationCheck.isPermutation("abc", "cab"));
    assertTrue(PermutationCheck.isPermutation("abc", "cba"));
    assertTrue(PermutationCheck.isPermutation("abc", "bac"));
    assertTrue(PermutationCheck.isPermutation("abc", "acb"));
    assertTrue(PermutationCheck.isPermutation("aabTT", "TabTa"));

    assertFalse(PermutationCheck.isPermutation("abc", ""));

    // Case sensitive permutation
    assertFalse(PermutationCheck.isPermutation("abc", "bCa"));

    assertFalse(PermutationCheck.isPermutation("abc", "abbc"));
    assertFalse(PermutationCheck.isPermutation("abc", "aec"));
    assertFalse(PermutationCheck.isPermutation("abc", "AAA"));

    // Unicode
    assertTrue(PermutationCheck.isPermutation("русский287", "йрс7скуи82"));
  }

  @Test
  public void testIsPermutation2() throws Exception {
    assertTrue(PermutationCheck.isPermutation2("abc", "bca"));
    assertTrue(PermutationCheck.isPermutation2("abc", "cab"));
    assertTrue(PermutationCheck.isPermutation2("abc", "cba"));
    assertTrue(PermutationCheck.isPermutation2("abc", "bac"));
    assertTrue(PermutationCheck.isPermutation2("abc", "acb"));
    assertTrue(PermutationCheck.isPermutation2("aabTT", "TabTa"));

    assertFalse(PermutationCheck.isPermutation2("abc", ""));

    // Case sensitive permutation
    assertFalse(PermutationCheck.isPermutation2("abc", "bCa"));

    assertFalse(PermutationCheck.isPermutation2("abc", "abbc"));
    assertFalse(PermutationCheck.isPermutation2("abc", "aec"));
    assertFalse(PermutationCheck.isPermutation2("abc", "AAA"));

    // Unicode
    assertTrue(PermutationCheck.isPermutation2("14русский", "йр4сскуи1"));
  }

  @Test
  public void testIsPermutation3() throws Exception {
    assertTrue(PermutationCheck.isPermutation3("abc", "bca"));
    assertTrue(PermutationCheck.isPermutation3("abc", "cab"));
    assertTrue(PermutationCheck.isPermutation3("abc", "cba"));
    assertTrue(PermutationCheck.isPermutation3("abc", "bac"));
    assertTrue(PermutationCheck.isPermutation3("abc", "acb"));
    assertTrue(PermutationCheck.isPermutation3("aabTT", "TabTa"));

    assertFalse(PermutationCheck.isPermutation3("abc", ""));

    // Case sensitive permutation
    assertFalse(PermutationCheck.isPermutation3("abc", "bCa"));

    assertFalse(PermutationCheck.isPermutation3("abc", "abbc"));
    assertFalse(PermutationCheck.isPermutation3("abc", "aec"));
    assertFalse(PermutationCheck.isPermutation3("abc", "AAA"));
  }
}