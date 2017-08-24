package chapter01.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCompressionTest {

  @Test
  public void testNotCompressed() throws Exception {
    assertEquals("empty string", "", BasicCompression.compress(""));
    assertEquals("abc", "abc", BasicCompression.compress("abc"));
  }

  @Test
  public void testCompress() throws Exception {
    assertEquals("a2b1c4a3", BasicCompression.compress("aabccccaaa"));
  }
}