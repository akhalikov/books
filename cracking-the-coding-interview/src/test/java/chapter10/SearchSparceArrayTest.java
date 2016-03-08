package chapter10;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link SearchSparceArray}
 *
 * @author akhalikov
 */
public class SearchSparceArrayTest {
  @Test
  public void testSearch() throws Exception {
    String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
    assertEquals("search for 'ball'", 4, SearchSparceArray.search(arr, "ball"));
    assertEquals("search for 'notexists'", -1, SearchSparceArray.search(arr, "notexists"));

    String[] arr2 = {"", "", "", "", "", "", "", "", "", "", "", "", ""};
    assertEquals("search in array of empty strings'", -1, SearchSparceArray.search(arr2, "dad"));
  }
}