package chapter16;

import static chapter16.EnglishInt.intToPhrase;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnglishIntTest {
  @Test
  public void testSmalls() {
    assertEquals("zero", intToPhrase(0));
    assertEquals("eight", intToPhrase(8));
    assertEquals("ten", intToPhrase(10));
  }

  @Test
  public void testThousand() {
    assertEquals("one thousand two hundred thirty four",
      intToPhrase(1_234));
  }

  //@Test
  public void testBigs() {
    assertEquals("hundred millions thirty thousands",
      intToPhrase(100_030_000));
  }
}