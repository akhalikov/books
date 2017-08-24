package chapter10.sortedsearch;

import static chapter10.sortedsearch.SortedSearch.find;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedSearchTest {
  @Test
  public void testFind() {
    Listy listy = new Listy(1, 3, 4, 5, 8, 8, 10, 15, 23);
    assertEquals(0, find(listy, 1));
    assertEquals(4, find(listy, 8));
    assertEquals(6, find(listy, 10));
    assertEquals(8, find(listy, 23));
    assertEquals(-1, find(listy, 155));
  }
}