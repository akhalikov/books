package chapter09.socialnetwork;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by akhalikov on 03/03/16
 */
public class NetworkSearch {
  LinkedList<Person> findPathBiBFS(Map<Integer, Person> people,
                                   int source, int dest) {
    BFSData sourceData = new BFSData(people.get(source));
    BFSData destData = new BFSData(people.get(dest));

    while (!sourceData.isFinished() && !destData.isFinished()) {
      Person collision = searchLevel(people, sourceData, destData);
      if (collision != null)
        return mergePaths(sourceData, destData, collision.getId());

      // Search out from destination
      collision = searchLevel(people, destData, sourceData);
      if (collision != null)
        return mergePaths(sourceData, destData, collision.getId());
    }
    return null;
  }

  /**
   * Search one level and return collision if any
   */
  Person searchLevel(Map<Integer, Person> people,
                     BFSData primary, BFSData secondary) {
    int count = primary.toVisit.size();
    for (int i = 0; i < count; i++) {
      PathNode pathNode = primary.toVisit.poll();
      int personId = pathNode.getPerson().getId();

      // Check if it's already been visited
      if (secondary.visited.containsKey(personId))
        return pathNode.getPerson();

      // Add friends to queue
      Person person = pathNode.getPerson();
      List<Integer> friends = person.getFriends();
      for (int friendId: friends) {
        if (!primary.visited.containsKey(friendId)) {
          Person friend = people.get(friendId);
          PathNode next = new PathNode(friend, pathNode);
          primary.visited.put(friendId, next);
          primary.toVisit.add(next);
        }
      }
    }
    return null;
  }

  LinkedList<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
    PathNode end1 = bfs1.visited.get(connection); // end1 -> source
    PathNode end2 = bfs2.visited.get(connection); // end2 -> dest
    LinkedList<Person> path1 = end1.collapse(false);
    LinkedList<Person> path2 = end2.collapse(true); // reverse
    path2.removeFirst(); // remove connection
    path1.addAll(path2); // add second path
    return path1;
  }
}
