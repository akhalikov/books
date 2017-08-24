package chapter10;

import static chapter10.SearchSparceArray.search;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchSparceArrayTest {
  @Test
  public void testSearch() throws Exception {
    String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
    assertEquals("search for 'ball'", 4, search(arr, "ball"));
    assertEquals("search for 'notexists'", -1, search(arr, "notexists"));

    String[] arr2 = {"", "", "", "", "", "", "", "", "", "", "", "", ""};
    assertEquals("search in array of empty strings'", -1, search(arr2, "dad"));
  }
}