package other.lists;

/**
 * Compare two strings represented as linked lists
 *
 * Given two linked lists, represented as linked lists (every character
 * is a node in linked list). Write a function compare() that works similar to strcmp(),
 * i.e., it returns 0 if both strings are same, 1 if first linked list is lexicographically
 * greater, and -1 if second string is lexicographically greater.
 *
 * Input:
 *  list1 = g->e->e->k->s->a
 *  list2 = g->e->e->k->s->b
 *  Output: -1
 *
 * Input:
 *  list1 = g->e->e->k->s->a
 *  list2 = g->e->e->k->s
 *  Output: 1
 *
 * Input:
 *  list1 = g->e->e->k->s
 *  list2 = g->e->e->k->s
 *  Output: 0
 *
 * Created by akhalikov on 27/02/16
 */
public class CompareLists {

  static int compare(Node list1, Node list2) {
    // run through lists
    while (list1 != null
        && list2 != null
        && list1.value == list2.value) {
      list1 = list1.next;
      list2 = list2.next;
    }

    // if we stopped, it means that either one or both of the lists are null,
    // or characters are not equal

    // if list1 is shorter than list2 => list1 is less than list2
    if (list1 == null && list2 != null)
      return -1;

    // if list2 is shorter than list1 => list1 is greater than list2
    if (list1 != null && list2 == null)
      return 1;

    // if characters are not equal
    if (list1 != null && list2 != null)
      return list1.value > list2.value ? 1: -1;

    // lists are equal
    return 0;
  }

  static class Node {
    char value;
    Node next;

    public Node(char c) {
      this.value = c;
    }

    public Node(char c, Node next) {
      this.value = c;
      this.next = next;
    }
  }
}
