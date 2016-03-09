package chapter08;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Test for {@link PermutationsWithDupes}
 */
public class PermutationsWithDupesTest {
  @Test
  public void testUnique() {
    Set<String> result = PermutationsWithDupes.getPermutations("abc");
    assertEquals(6, result.size());
    assertTrue(result.contains("abc"));
    assertTrue(result.contains("acb"));
    assertTrue(result.contains("bac"));
    assertTrue(result.contains("bca"));
    assertTrue(result.contains("cab"));
    assertTrue(result.contains("cba"));
  }

  @Test
  public void testDupes() {
    Set<String> result = PermutationsWithDupes.getPermutations("aaa");
    assertEquals(1, result.size());
    assertTrue(result.contains("aaa"));
  }
}