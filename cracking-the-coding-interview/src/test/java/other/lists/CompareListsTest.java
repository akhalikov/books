package other.lists;

import careercup.other.lists.CompareLists.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test CompareListsTest
 */
public class CompareListsTest {
  @Test
  public void testCompareTrue() {
    Node a = new Node('g', new Node('e', new Node('e', new Node('k', new Node('s')))));
    Node b = new Node('g', new Node('e', new Node('e', new Node('k', new Node('s')))));
    assertEquals(0, CompareLists.compare(a, b));
  }

  @Test
  public void testCompareGreater() {
    Node a = new Node('g', new Node('e', new Node('e', new Node('k', new Node('s', new Node('a'))))));
    Node b = new Node('g', new Node('e', new Node('e', new Node('k', new Node('s')))));
    assertEquals(1, CompareLists.compare(a, b));
  }

  @Test
  public void testCompareSmaller() {
    Node a = new Node('g', new Node('e', new Node('e', new Node('k', new Node('s', new Node('a'))))));
    Node b = new Node('g', new Node('e', new Node('e', new Node('k', new Node('s', new Node('b'))))));
    assertEquals(-1, CompareLists.compare(a, b));
  }
}