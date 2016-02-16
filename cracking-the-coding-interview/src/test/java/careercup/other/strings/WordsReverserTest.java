package careercup.other.strings;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link WordsReverser}
 *
 * Created by akhalikov on 25/01/16
 */
public class WordsReverserTest {
  @Test
  public void testReverse() throws Exception {
    assertEquals("", WordsReverser.reverse(""));
    assertEquals("loneliness", WordsReverser.reverse("loneliness"));
    assertEquals("awesome! are Interviews",
      WordsReverser.reverse("   Interviews are awesome!   "));
  }

  @Test
  public void testReverse2() throws Exception {
    assertEquals("", WordsReverser.reverse2(""));
    assertEquals("   ", WordsReverser.reverse2("   "));
    assertEquals("a", WordsReverser.reverse2("   a"));
    assertEquals("loneliness", WordsReverser.reverse2("loneliness"));
    assertEquals("awesome! are Interviews",
      WordsReverser.reverse2("  Interviews are awesome!  "));
  }

  @Test
  public void testReverse3() throws Exception {
    char[] chars = "hello, world!".toCharArray();
    WordsReverser.reverse3(chars);
    Lists.newArrayList(chars).forEach(System.out::println);
    assertArrayEquals("world! hello,".toCharArray(), chars);
  }
}