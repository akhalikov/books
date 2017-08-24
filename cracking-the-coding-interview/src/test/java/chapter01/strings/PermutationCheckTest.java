package chapter01.strings;

import static chapter01.strings.PermutationCheck.isPermutation;
import static chapter01.strings.PermutationCheck.isPermutation2;
import static chapter01.strings.PermutationCheck.isPermutation3;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PermutationCheckTest {
  @Test
  public void testIsPermutation() throws Exception {
    assertTrue(isPermutation("abc", "bca"));
    assertTrue(isPermutation("abc", "cab"));
    assertTrue(isPermutation("abc", "cba"));
    assertTrue(isPermutation("abc", "bac"));
    assertTrue(isPermutation("abc", "acb"));
    assertTrue(isPermutation("aabTT", "TabTa"));

    assertFalse(isPermutation("abc", ""));

    // Case sensitive permutation
    assertFalse(isPermutation("abc", "bCa"));

    assertFalse(isPermutation("abc", "abbc"));
    assertFalse(isPermutation("abc", "aec"));
    assertFalse(isPermutation("abc", "AAA"));

    // Unicode
    assertTrue(isPermutation("русский287", "йрс7скуи82"));
  }

  @Test
  public void testIsPermutation2() throws Exception {
    assertTrue(isPermutation2("abc", "bca"));
    assertTrue(isPermutation2("abc", "cab"));
    assertTrue(isPermutation2("abc", "cba"));
    assertTrue(isPermutation2("abc", "bac"));
    assertTrue(isPermutation2("abc", "acb"));
    assertTrue(isPermutation2("aabTT", "TabTa"));

    assertFalse(isPermutation2("abc", ""));

    // Case sensitive permutation
    assertFalse(isPermutation2("abc", "bCa"));

    assertFalse(isPermutation2("abc", "abbc"));
    assertFalse(isPermutation2("abc", "aec"));
    assertFalse(isPermutation2("abc", "AAA"));

    // Unicode
    assertTrue(isPermutation2("14русский", "йр4сскуи1"));
  }

  @Test
  public void testIsPermutation3() throws Exception {
    assertTrue(isPermutation3("abc", "bca"));
    assertTrue(isPermutation3("abc", "cab"));
    assertTrue(isPermutation3("abc", "cba"));
    assertTrue(isPermutation3("abc", "bac"));
    assertTrue(isPermutation3("abc", "acb"));
    assertTrue(isPermutation3("aabTT", "TabTa"));

    assertFalse(isPermutation3("abc", ""));

    // Case sensitive permutation
    assertFalse(isPermutation3("abc", "bCa"));

    assertFalse(isPermutation3("abc", "abbc"));
    assertFalse(isPermutation3("abc", "aec"));
    assertFalse(isPermutation3("abc", "AAA"));
  }
}