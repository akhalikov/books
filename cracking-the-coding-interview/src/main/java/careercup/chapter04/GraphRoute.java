package careercup.chapter04;

import algo.graphs.Graph;
import algo.graphs.Graph.Node.State;
import algo.queue.LinkedQueue;
import algo.queue.Queue;

/**
 * Given a directed graph, design an algorithm
 * to find out whether there is a route between two nodes.
 */
public class GraphRoute {
  /**
   * Find the shortest route using BFS
   */
  static boolean hasRoute(Graph g, Graph.Node fromNode, Graph.Node toNode) {
    if (fromNode == toNode)
      return true;

    ensureUnvisited(g);
    final Queue<Graph.Node> queue = new LinkedQueue();
    queue.add(fromNode);
    fromNode.setState(State.Visiting);

    Graph.Node node;
    while (!queue.isEmpty()) {
      node = queue.remove();
      if (node != null) {
        for (Graph.Node adjacent: node.getAdjacentNodes()) {
          if (State.Unvisited == adjacent.getState()) {
            if (adjacent == toNode)
              return true;
            adjacent.setState(State.Visiting);
            queue.add(adjacent);
          }
        }
        node.setState(State.Visited);
      }
    }
    return false;
  }

  private static void ensureUnvisited(final Graph g) {
    g.getNodes().forEach(n -> {
      if (State.Unvisited != n.getState())
        n.setState(State.Unvisited);
    });
  }
}
