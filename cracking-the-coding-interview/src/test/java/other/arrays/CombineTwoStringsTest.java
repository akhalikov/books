package other.arrays;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test for {@link CombineTwoStrings}
 *
 * Created by artur on 05.02.16.
 */
public class CombineTwoStringsTest {
  @Test
  public void testIsValidShuffle() throws Exception {
    assertTrue(CombineTwoStrings.isValidShuffle("abc", "def", "dabecf"));
    assertTrue(CombineTwoStrings.isValidShuffle("abc", "", "abc"));
    assertTrue(CombineTwoStrings.isValidShuffle("", "123", "123"));
    assertTrue(CombineTwoStrings.isValidShuffle("abc", "def", "defabc"));
  }
}