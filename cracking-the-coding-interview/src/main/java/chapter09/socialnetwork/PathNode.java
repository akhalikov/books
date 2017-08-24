package chapter09.socialnetwork;

import java.util.LinkedList;

public class PathNode {
  private Person person = null;
  private PathNode prev = null;

  PathNode(Person person, PathNode prev) {
    this.person = person;
    this.prev = prev;
  }

  LinkedList<Person> collapse(boolean startsWithRoot) {
    LinkedList<Person> path = new LinkedList<>();
    PathNode node = this;
    while (node != null) {
      if (startsWithRoot) {
        path.addLast(node.person);
      } else {
        path.addFirst(node.person);
      }
      node = node.prev;
    }
    return path;
  }

  Person getPerson() {
    return person;
  }
}
