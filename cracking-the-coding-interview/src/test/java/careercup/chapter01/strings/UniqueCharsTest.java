package careercup.chapter01.strings;

import org.junit.Test;

import static careercup.chapter01.strings.UniqueChars.isUniqueASCIIChars;
import static careercup.chapter01.strings.UniqueChars.isUniqueAlphaChars;
import static careercup.chapter01.strings.UniqueChars.isUniqueAlphaLowercasedChars;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link UniqueChars}
 *
 * @author akhalikov
 */
public class UniqueCharsTest {
    @Test
    public void testIsUniqueAlphaLowercasedChars() throws Exception {
        assertTrue(isUniqueAlphaLowercasedChars("a"));
        assertFalse(isUniqueAlphaLowercasedChars("aba"));
        assertFalse(isUniqueAlphaLowercasedChars("abacd abab ec 45"));
    }

    @Test
    public void testIsUniqueASCIIChars() throws Exception {
        assertTrue(isUniqueASCIIChars("a"));
        assertFalse(isUniqueASCIIChars("aba"));
        assertFalse(isUniqueASCIIChars("abacd abab ec 45"));
    }

    @Test
    public void testIsUniqueAlphaChars() throws Exception {
        assertTrue(isUniqueAlphaChars("a"));
        assertFalse(isUniqueAlphaChars("aba"));
        assertFalse(isUniqueAlphaChars("abacd abab ec 45"));
        assertTrue(isUniqueAlphaChars("abA"));
        assertFalse(isUniqueAlphaChars("AbAc"));
    }
}