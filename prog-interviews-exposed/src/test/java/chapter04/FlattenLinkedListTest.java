package chapter04;

import chapter04.FlattenLinkedList.Node;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link FlattenLinkedList}
 */
public class FlattenLinkedListTest {
  static Node aHead, aTail;
  static Node bHead, bTail;
  static Node b2Head, b2Tail;
  static Node cHead, cTail;
  static Node dHead, dTail;

  @Test
  public void testFlatten() {
    // constructing lists
    createLists();

  }

  /**
   * Input list:
   *
   * 5 -> 33 -> 17 -> 2 -> 1
   * |
   * 6 -> 25 -> 6     2 -> 7
   *                  |
   *                  12 -> 5
   *                  |
   *                  21 -> 3
   *
   * Expected output:
   *
   * 5->33->17->2->1->6->25->6->2->7->12->5->21->3
   */
  private static void createLists() {
    aHead = new Node(5);
    Node a2 = new Node(33);
    Node a3 = new Node(17);
    Node a4 = new Node(2);
    aTail = new Node(1);

    aHead.next = a2;
    a2.prev = aHead;
    a2.next = a3;

    a3.prev = a2;
    a3.next = a4;

    a4.prev = a3;
    a4.next = aTail;

    aTail.prev = a4;

    bHead = new Node(6);
    Node b2 = new Node(25);
    bTail = new Node(6);
    bHead.next = b2;
    b2.prev = bHead;
    b2.next = bTail;
    bTail.prev = b2;

    b2Head = new Node(2);
    b2Tail = new Node(7);
    b2Head.next = b2Tail;

    aHead.child = bHead;
    a4.child = b2Head;

    cHead = new Node(12);
    cTail = new Node(5);
    cHead.next = cTail;
    cTail.prev = cHead;

    b2Head.child = cHead;

    dHead = new Node(21);
    dTail = new Node(3);
    dHead.next = dTail;
    dTail.prev = dHead;

    cHead.child = dHead;
  }
}