package chapter04;

import algo.graphs.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link GraphRoute}
 *
 * @author akhalikov
 */
public class GraphRouteTest {
  @Test
  public void testHasRoute() throws Exception {
    Graph g = createTestGraph();
    assertTrue("true: 1->4", GraphRoute.hasRoute(g, g.getNode(0), g.getNode(3)));
    assertTrue("true: 1->1", GraphRoute.hasRoute(g, g.getNode(0), g.getNode(0)));
    assertFalse("false: 1->7", GraphRoute.hasRoute(g, g.getNode(0), g.getNode(6)));
    assertTrue("true: 6->7", GraphRoute.hasRoute(g, g.getNode(5), g.getNode(6)));
    assertFalse("true: 7->6", GraphRoute.hasRoute(g, g.getNode(6), g.getNode(5)));

  }

  Graph createTestGraph() {
    Graph.Node n2 = new Graph.Node("2");
    Graph.Node n4 = new Graph.Node("4", n2);
    Graph.Node n5 = new Graph.Node("5", n4);
    Graph.Node n3 = new Graph.Node("3", n4, n5);
    Graph.Node n1 = new Graph.Node("1", n2, n3);
    Graph.Node n7 = new Graph.Node("7");
    Graph.Node n6 = new Graph.Node("6", n7);
    return new Graph(n1, n2, n3, n4, n5, n6, n7);
  }
}
