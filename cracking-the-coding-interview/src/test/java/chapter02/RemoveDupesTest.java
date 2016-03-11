package chapter02;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Test for {@link RemoveDupes}
 */
public class RemoveDupesTest {

  @Test
  public void testRemoveDupesEmptyList() throws Exception {
    ListNode list = new ListNode(1, null);
    RemoveDupes.removeDupes(list);
    assertEquals(1, list.data);
    assertEquals(null, list.next);
  }

  @Test
  public void testRemoveDupes() throws Exception {
    ListNode list = new ListNode(6, new ListNode(5, new ListNode(3,
      new ListNode(2, new ListNode(4, new ListNode(1, new ListNode(2, null)))))));

    RemoveDupes.removeDupes(list);
    assertEquals(6, list.data);
    ListNode p = list.next;
    assertEquals(5, p.data);

    p = p.next;
    assertEquals(3, p.data);

    p = p.next;
    assertEquals(2, p.data);

    p = p.next;
    assertEquals(4, p.data);

    p = p.next;
    assertEquals(1, p.data);

    p = p.next;
    assertNull(p);
  }

  @Test
  public void testRemoveDupes2() throws Exception {
    ListNode list = new ListNode(6, new ListNode(5, new ListNode(3,
      new ListNode(2, new ListNode(4, new ListNode(1, new ListNode(2, null)))))));

    RemoveDupes.removeDupes2(list);
    assertEquals(6, list.data);
    ListNode p = list.next;
    assertEquals(5, p.data);

    p = p.next;
    assertEquals(3, p.data);

    p = p.next;
    assertEquals(2, p.data);

    p = p.next;
    assertEquals(4, p.data);

    p = p.next;
    assertEquals(1, p.data);

    p = p.next;
    assertNull(p);
  }
}