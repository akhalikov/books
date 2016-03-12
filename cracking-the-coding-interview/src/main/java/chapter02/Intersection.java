package chapter02;

import chapter02.LinkedList.Node;

/**
 * Given two singly linked lists, determine if two lists intersect.
 * Return the intersecting node. Note that the intersection is defined based on reference, not value.
 *
 * That is, if k-th node of first LL is the exact same node (by ref) as the j-th node of the second LL,
 * then they're intersecting.
 *
 * @author akhalikov
 */
public class Intersection {
  static Node findIntersection(Node first, Node second) {
    int len1 = length(first);
    int len2 = length(second);
    Node shorter = len1 < len2 ? first : second;
    Node longer = len1 < len2 ? second: first;
    int delta = Math.abs(len1 - len2);
    while (delta > 0) {
      longer = longer.next;
      delta--;
    }
    while (shorter != null && longer != null) {
      if (shorter == longer)
        return shorter;
      shorter = shorter.next;
      longer = longer.next;
    }
    return null;
  }

  private static int length(Node node) {
    int n = 0;
    while (node != null) {
      n++;
      node = node.next;
    }
    return n;
  }
}
