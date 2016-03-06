package careercup.chapter16;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test EnglishIntTest
 */
public class EnglishIntTest {
  @Test
  public void testSmalls() {
    assertEquals("zero", EnglishInt.intToPhrase(0));
    assertEquals("eight", EnglishInt.intToPhrase(8));
    assertEquals("ten", EnglishInt.intToPhrase(10));
  }

  @Test
  public void testThousand() {
    assertEquals(
      "one thousand two hundred thirty four",
      EnglishInt.intToPhrase(1_234));
  }

  //@Test
  public void testBigs() {
    assertEquals(
      "hundred millions thirty thousands",
      EnglishInt.intToPhrase(100_030_000));
  }
}