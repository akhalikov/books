package chapter02;

import chapter02.LinkedList.Node;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Test for {@link RemoveDupes}
 */
public class RemoveDupesTest {

  @Test
  public void testRemoveDupesEmptyList() throws Exception {
    Node list = new Node(1, null);
    RemoveDupes.removeDupes(list);
    assertEquals(1, list.data);
    assertEquals(null, list.next);
  }

  @Test
  public void testRemoveDupes() throws Exception {
    Node list = new Node(6, new Node(5, new Node(3,
      new Node(2, new Node(4, new Node(1, new Node(2, null)))))));

    RemoveDupes.removeDupes(list);
    assertEquals(6, list.data);
    Node p = list.next;
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
    Node list = new Node(6, new Node(5, new Node(3,
      new Node(2, new Node(4, new Node(1, new Node(2, null)))))));

    RemoveDupes.removeDupes2(list);
    assertEquals(6, list.data);
    Node p = list.next;
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