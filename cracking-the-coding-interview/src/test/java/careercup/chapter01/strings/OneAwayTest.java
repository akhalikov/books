package careercup.chapter01.strings;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author akhalikov
 */
public class OneAwayTest {
  @Test
  public void testIsOneAway() throws Exception {
    assertTrue(OneAway.isOneAway("", ""));
    assertTrue(OneAway.isOneAway("pale", "pale"));

    assertTrue(OneAway.isOneAway("pale", "bale"));
    assertTrue(OneAway.isOneAway("pales", "pale"));
    assertTrue(OneAway.isOneAway("pale", "ple"));

    assertFalse(OneAway.isOneAway("pale", "paaaale"));
    assertFalse(OneAway.isOneAway("bake", "pale"));
    assertFalse(OneAway.isOneAway("omega", "meg"));
  }

  @Test
  public void testIsOneAway2() throws Exception {
    assertTrue(OneAway.isOneAway2("", ""));
    assertTrue(OneAway.isOneAway2("pale", "pale"));

    assertTrue(OneAway.isOneAway2("pale", "bale"));
    assertTrue(OneAway.isOneAway2("pales", "pale"));
    assertTrue(OneAway.isOneAway2("pale", "ple"));

    assertFalse(OneAway.isOneAway2("pale", "paaaale"));
    assertFalse(OneAway.isOneAway2("bake", "pale"));
    assertFalse(OneAway.isOneAway2("omega", "meg"));
  }
}