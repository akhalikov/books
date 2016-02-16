package careercup.chapter01.strings;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Test for {@link URLify}
 *
 * @author akhalikov
 */
public class URLifyTest {

  @Test
  public void testUrlify() throws Exception {
    char[] actual = "Mr John Smith    ".toCharArray();
    assertArrayEquals("Mr%20John%20Smith".toCharArray(), URLify.replaceSpaces(actual, 13));
  }

  @Test
  public void testUrlify1() throws Exception {
    char[] actual = "ab   ".toCharArray();
    assertArrayEquals("ab%20".toCharArray(), URLify.replaceSpaces(actual, 3));
  }

  @Test
  public void testUrlify2() throws Exception {
    char[] actual = " abc  ".toCharArray();
    assertArrayEquals("%20abc".toCharArray(), URLify.replaceSpaces(actual, 4));
  }

  @Test
  public void testUrlify3() throws Exception {
    char[] actual = "   ".toCharArray();
    assertArrayEquals("%20".toCharArray(), URLify.replaceSpaces(actual, 1));
  }

  @Test
  public void testUrlify4() throws Exception {
    char[] actual = "".toCharArray();
    assertArrayEquals("".toCharArray(), URLify.replaceSpaces(actual, 0));
  }
}