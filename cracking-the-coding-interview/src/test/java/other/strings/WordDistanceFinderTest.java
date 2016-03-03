package other.strings;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link WordDistanceFinder}
 *
 * Created by akhalikov on 24/01/16
 */
public class WordDistanceFinderTest {
  @Test
  public void testDistance() throws Exception {
    WordDistanceFinder finder = new WordDistanceFinder(
      Arrays.asList("the", "quick", "brown", "fox", "quick"));

    assertEquals(3, finder.distance("fox","the"));
    assertEquals(1, finder.distance("quick", "fox"));
  }
}