package chapter04.buildorder;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link BuildOrder}
 */
public class BuildOrderTest {
  @Test
  public void testFindBuildOrder() {
    Project a = new Project("a");
    Project e = new Project("e");
    Project f = new Project("f");
    Project b = new Project("b", f);
    Project d = new Project("d", a, b);
    Project c = new Project("c", d);
    a.addDependency(f);
    BuildGraph bg = new BuildGraph(a, b, c, d, e, f);
  }
}