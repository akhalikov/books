package chapter09.socialnetwork;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS data
 */
class BFSData {
  Queue<PathNode> toVisit = new LinkedList<>();
  HashMap<Integer, PathNode> visited = new HashMap<>();

  BFSData(Person root) {
    PathNode sourcePath = new PathNode(root, null);
    toVisit.add(sourcePath);
    visited.put(root.getId(), sourcePath);
  }

  boolean isFinished() {
    return toVisit.isEmpty();
  }
}
