package chapter10;

import static com.ahalikov.toolkit.utils.ArrayUtils.print;
import org.junit.Test;
import com.ahalikov.toolkit.utils.ArrayUtils;

import static org.junit.Assert.*;

public class GroupAnagramsTest {
  @Test
  public void testSort() throws Exception {
    System.out.println("testSort");
    String[] actual = new String[]{"abab", "Google", "Amazon", "Moo", "abba", "baba"};
    GroupAnagrams.sort(actual);
    print(actual);
    assertArrayEquals(
      new String[]{"abab", "abba", "baba", "Amazon", "Google", "Moo"},
      actual
    );
  }

  @Test
  public void testSort2() throws Exception {
    System.out.println("testSort2");
    String[] actual = new String[]{"abab", "Google", "Amazon", "Microsoft", "abba", "baba"};
    GroupAnagrams.sort2(actual);
    print(actual);
  }
}