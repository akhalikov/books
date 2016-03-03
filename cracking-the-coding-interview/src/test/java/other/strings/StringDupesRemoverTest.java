package other.strings;

import com.ahalikov.toolkit.utils.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test for {@link StringDupesRemover}
 *
 * @author ahalikov
 */
public class StringDupesRemoverTest {
  @Test
  public void testRemoveDupes4() throws Exception {
    assertNull(StringDupesRemover.removeDupes4(null));

    char[] s = new char[0];
    assertEquals(s, StringDupesRemover.removeDupes4(s));

    char[] actual;
    actual = StringDupesRemover.removeDupes4("abba".toCharArray());
    ArrayUtils.print(actual);

    actual = StringDupesRemover.removeDupes4("adammadamme".toCharArray());
    ArrayUtils.print(actual);

    actual = StringDupesRemover.removeDupes4("abcabcabcu".toCharArray());
    ArrayUtils.print(actual);
  }
}