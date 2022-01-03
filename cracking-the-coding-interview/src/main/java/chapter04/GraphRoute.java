package chapter04;

import algo.graphs.Graph;
import algo.graphs.Node;
import algo.queue.LinkedQueue;
import algo.queue.Queue;

import static algo.graphs.NodeState.UNVISITED;
import static algo.graphs.NodeState.VISITED;
import static algo.graphs.NodeState.VISITING;

/**
 * Given a directed graph, design an algorithm
 * to find out whether there is a route between two nodes.
 */
public class GraphRoute {

    /**
     * Find the shortest route using BFS
     */
    static boolean hasRoute(Graph g, Node fromNode, Node toNode) {
        if (fromNode == toNode)
            return true;

        ensureUnvisited(g);
        final Queue<Node> queue = new LinkedQueue<>();
        queue.add(fromNode);
        fromNode.withState(VISITING);

        Node node;
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node != null) {
                for (final Node adjacent : node.adjacentNodes) {
                    if (adjacent.state() == UNVISITED) {
                        if (adjacent == toNode)
                            return true;
                        adjacent.withState(VISITING);
                        queue.add(adjacent);
                    }
                }
                node.withState(VISITED);
            }
        }
        return false;
    }

    private static void ensureUnvisited(final Graph g) {
        g.nodes.forEach(n -> {
            if (UNVISITED != n.state())
                n.withState(UNVISITED);
        });
    }
}
