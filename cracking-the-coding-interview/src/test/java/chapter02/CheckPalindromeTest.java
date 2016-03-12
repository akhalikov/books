package chapter02;

import chapter02.LinkedList.Node;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.awt.*;

import static org.junit.Assert.assertTrue;

/**
 * Test for {@link CheckPalindrome}
 *
 * @author akhalikov
 */
public class CheckPalindromeTest {
  @Test
  public void testIsPalindrome() throws Exception {
    // odd number of items
    LinkedList list1 = LinkedList.fromArray(4, 3, 2, 1, 2, 3, 4);
    assertTrue(CheckPalindrome.isPalindrome(list1.head));

    // even number of items
    LinkedList list2 = LinkedList.fromArray(4, 3, 2, 2, 3, 4);
    assertTrue(CheckPalindrome.isPalindrome(list2.head));

    // one item
    Node list3 = new Node(33);
    assertTrue(CheckPalindrome.isPalindrome(list3));
  }

  @Test
  public void testIsPalindrome2() throws Exception {
    // odd number of items
    LinkedList list1 = LinkedList.fromArray(4, 3, 2, 1, 2, 3, 4);
    assertTrue(CheckPalindrome.isPalindrome2(list1.head));

    // even number of items
    LinkedList list2 = LinkedList.fromArray(4, 3, 2, 2, 3, 4);
    assertTrue(CheckPalindrome.isPalindrome2(list2.head));

    // one item
    Node list3 = new Node(33);
    assertTrue(CheckPalindrome.isPalindrome2(list3));
  }

  @Test(expected = NullPointerException.class)
  public void testIsPalindromeNullList() throws Exception {
    assertTrue(CheckPalindrome.isPalindrome(null));
  }
}