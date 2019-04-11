package chapter04.buildorder;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BuildOrderTest {

  @Test
  public void test1() {
    BuildGraph graph = new BuildGraph();
    graph
        .addNode("e")
        .addEdge("a", "d")
        .addEdge("f", "b")
        .addEdge("b", "d")
        .addEdge("f", "a")
        .addEdge("d", "c");

    List<Project> order = graph.findBuildOrder();

    String name0 = order.get(0).getName();
    assertEqualsOr("f", "e", name0);

    String name1 = order.get(1).getName();
    assertNotEquals(name0, name1);
    assertEqualsOr("f", "e", name1);

    assertEquals("a", order.get(2).getName());
    assertEquals("b", order.get(3).getName());
    assertEquals("d", order.get(4).getName());
    assertEquals("c", order.get(5).getName());
  }

  @Test
  public void test2() {
    BuildGraph graph = new BuildGraph();
    graph
        .addEdge("d", "g")
        .addEdge("f", "b")
        .addEdge("f", "c")
        .addEdge("f", "a")
        .addEdge("c", "a")
        .addEdge("b", "a")
        .addEdge("b", "h")
        .addEdge("b", "e");

    List<Project> order = graph.findBuildOrder();

    String name0 = order.get(0).getName();
    assertEqualsOr("f", "d", name0);

    assertEquals("g", order.get(1).getName());
    assertEquals("f", order.get(2).getName());

    String name3 = order.get(3).getName();
    assertEqualsOr("c", "b", name3);

    String name4 = order.get(4).getName();
    assertEqualsOr("c", "b", name4);
    assertNotEquals(name3, name4);

    assertEquals("a", order.get(5).getName());
    assertEquals("h", order.get(6).getName());
    assertEquals("e", order.get(7).getName());
  }

  private static void assertEqualsOr(String expected1, String expected2, String actual) {
    assertTrue(
        expected1.equals(actual)
            || expected2.equals(actual)
    );
  }
}