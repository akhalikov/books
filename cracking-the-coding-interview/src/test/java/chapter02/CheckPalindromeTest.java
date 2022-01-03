package chapter02;

import chapter02.LinkedList.Node;
import org.junit.Test;

import static chapter02.CheckPalindrome.isPalindrome;
import static chapter02.CheckPalindrome.isPalindrome2;
import static chapter02.LinkedList.fromArray;
import static org.junit.Assert.assertTrue;

public class CheckPalindromeTest {

    @Test
    public void testIsPalindrome() {
        // odd number of items
        var list1 = fromArray(4, 3, 2, 1, 2, 3, 4);
        assertTrue(isPalindrome(list1.head));

        // even number of items
        var list2 = fromArray(4, 3, 2, 2, 3, 4);
        assertTrue(isPalindrome(list2.head));

        // one item
        var list3 = new Node(33);
        assertTrue(isPalindrome(list3));
    }

    @Test
    public void testIsPalindrome2() {
        // odd number of items
        var list1 = fromArray(4, 3, 2, 1, 2, 3, 4);
        assertTrue(isPalindrome2(list1.head));

        // even number of items
        var list2 = fromArray(4, 3, 2, 2, 3, 4);
        assertTrue(isPalindrome2(list2.head));

        // one item
        var list3 = new Node(33);
        assertTrue(isPalindrome2(list3));
    }

    @Test(expected = NullPointerException.class)
    public void testIsPalindromeNullList() {
        assertTrue(isPalindrome(null));
    }
}