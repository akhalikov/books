package chapter08;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link TripleStep}
 */
public class TripleStepTest {
  @Test
  public void testCountWays() {
    assertEquals(1, TripleStep.countWays(1));
    assertEquals(2, TripleStep.countWays(2));
    assertEquals(4, TripleStep.countWays(3));
  }

  @Test
  public void testCountWaysIter() {
    assertEquals(1, TripleStep.countWaysIter(1));
    assertEquals(2, TripleStep.countWaysIter(2));
    assertEquals(4, TripleStep.countWaysIter(3));

    int expected = TripleStep.countWays(7);
    System.out.println("countWays(7)=" + expected);
    assertEquals(expected, TripleStep.countWaysIter(7));

    expected = TripleStep.countWays(12);
    System.out.println("countWays(12)=" + expected);
    assertEquals(expected, TripleStep.countWaysIter(12));
  }

  @Test
  public void testCountWaysMemo() {
    assertEquals(1, TripleStep.countWaysMemo(1));
    assertEquals(2, TripleStep.countWaysMemo(2));
    assertEquals(4, TripleStep.countWaysMemo(3));
    assertEquals(44, TripleStep.countWaysMemo(7));
    assertEquals(927, TripleStep.countWaysMemo(12));
  }
}