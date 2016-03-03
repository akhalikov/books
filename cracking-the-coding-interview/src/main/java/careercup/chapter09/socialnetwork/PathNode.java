package careercup.chapter09.socialnetwork;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by akhalikov on 03/03/16
 */
public class PathNode {
  private Person person = null;
  private PathNode prev = null;

  public PathNode(Person person, PathNode prev) {
    this.person = person;
    this.prev = prev;
  }

  public LinkedList<Person> collapse(boolean startsWithRoot) {
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

  public Person getPerson() {
    return person;
  }
}
