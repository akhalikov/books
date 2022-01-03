package chapter04;

import algo.graphs.Graph;

import static chapter04.GraphRoute.hasRoute;

import algo.graphs.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphRouteTest {

    @Test
    public void testHasRoute() {
        // given
        var n2 = new Node("2");
        var n4 = new Node("4", n2);
        var n5 = new Node("5", n4);
        var n3 = new Node("3", n4, n5);
        var n1 = new Node("1", n2, n3);
        var n7 = new Node("7");
        var n6 = new Node("6", n7);
        var g = new Graph(n1, n2, n3, n4, n5, n6, n7);

        // when / then
        assertTrue("true: 1->4", hasRoute(g, g.nodeAt(0), g.nodeAt(3)));
        assertTrue("true: 1->1", hasRoute(g, g.nodeAt(0), g.nodeAt(0)));
        assertFalse("false: 1->7", hasRoute(g, g.nodeAt(0), g.nodeAt(6)));
        assertTrue("true: 6->7", hasRoute(g, g.nodeAt(5), g.nodeAt(6)));
        assertFalse("true: 7->6", hasRoute(g, g.nodeAt(6), g.nodeAt(5)));

    }
}
