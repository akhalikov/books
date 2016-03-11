package chapter02;

import org.junit.Test;

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
    ListNode list1 = new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1,
      new ListNode(2, new ListNode(3, new ListNode(4, null)))))));
    assertTrue(CheckPalindrome.isPalindrome(list1));

    // even number of items
    ListNode list2 = new ListNode(4, new ListNode(3, new ListNode(2,
      new ListNode(2, new ListNode(3, new ListNode(4, null))))));
    assertTrue(CheckPalindrome.isPalindrome(list2));

    // one item
    ListNode head = new ListNode(33, null);
    assertTrue(CheckPalindrome.isPalindrome(head));
  }

  @Test
  public void testIsPalindrome2() throws Exception {
    // odd number of items
    ListNode list1 = new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1,
      new ListNode(2, new ListNode(3, new ListNode(4, null)))))));
    assertTrue(CheckPalindrome.isPalindrome2(list1));

    // even number of items
    ListNode list2 = new ListNode(4, new ListNode(3, new ListNode(2,
      new ListNode(2, new ListNode(3, new ListNode(4, null))))));
    assertTrue(CheckPalindrome.isPalindrome2(list2));

    // one item
    ListNode head = new ListNode(33, null);
    assertTrue(CheckPalindrome.isPalindrome2(head));
  }

  @Test(expected = NullPointerException.class)
  public void testIsPalindromeNullList() throws Exception {
    assertTrue(CheckPalindrome.isPalindrome(null));
  }
}