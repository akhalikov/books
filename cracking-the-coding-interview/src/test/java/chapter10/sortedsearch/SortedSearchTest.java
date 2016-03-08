package chapter10.sortedsearch;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link SortedSearch}
 */
public class SortedSearchTest {
  @Test
  public void testFind() {
    Listy listy = new Listy(1, 3, 4, 5, 8, 8, 10, 15, 23);
    assertEquals(0, SortedSearch.find(listy, 1));
    assertEquals(4, SortedSearch.find(listy, 8));
    assertEquals(6, SortedSearch.find(listy, 10));
    assertEquals(8, SortedSearch.find(listy, 23));
    assertEquals(-1, SortedSearch.find(listy, 155));
  }
}