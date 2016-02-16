package careercup.chapter02;

import careercup.chapter02.CheckPalindrome.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link CheckPalindrome}
 *
 * @author akhalikov
 */
public class CheckPalindromeTest {
  @Test
  public void testIsPalindrome() throws Exception {
    // odd number of items
    Node list1 = new Node(4, new Node(3, new Node(2, new Node(1,
      new Node(2, new Node(3, new Node(4, null)))))));
    assertTrue(CheckPalindrome.isPalindrome(list1));

    // even number of items
    Node list2 = new Node(4, new Node(3, new Node(2,
      new Node(2, new Node(3, new Node(4, null))))));
    assertTrue(CheckPalindrome.isPalindrome(list2));

    // one item
    Node head = new Node(33, null);
    assertTrue(CheckPalindrome.isPalindrome(head));
  }

  @Test
  public void testIsPalindrome2() throws Exception {
    // odd number of items
    Node list1 = new Node(4, new Node(3, new Node(2, new Node(1,
      new Node(2, new Node(3, new Node(4, null)))))));
    assertTrue(CheckPalindrome.isPalindrome2(list1));

    // even number of items
    Node list2 = new Node(4, new Node(3, new Node(2,
      new Node(2, new Node(3, new Node(4, null))))));
    assertTrue(CheckPalindrome.isPalindrome2(list2));

    // one item
    Node head = new Node(33, null);
    assertTrue(CheckPalindrome.isPalindrome2(head));
  }

  @Test(expected = NullPointerException.class)
  public void testIsPalindromeNullList() throws Exception {
    assertTrue(CheckPalindrome.isPalindrome(null));
  }
}