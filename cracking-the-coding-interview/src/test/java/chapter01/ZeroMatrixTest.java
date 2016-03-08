package chapter01;

import org.junit.Test;
import com.ahalikov.toolkit.utils.ArrayUtils;

/**
 * Test for {@link ZeroMatrix}
 *
 * @author ahalikov
 */
public class ZeroMatrixTest {
  @Test
  public void testProcess1() throws Exception {
    int[][] m = {{1, 2, 3}, {5, 0, 4}, {1, 2, 3}};
    ZeroMatrix.makeZeros(m);
    int[][] expect = {{1, 0, 3}, {0, 0, 0}, {1, 0, 3}};
    ArrayUtils.assertMatrixEquals(expect, m);
  }

  @Test
  public void testProcess2() throws Exception {
    int[][] m = {{1, 2, 3}, {5, 0, 4}, {1, 2, 0}};
    ZeroMatrix.makeZeros(m);
    int[][] expect = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    ArrayUtils.assertMatrixEquals(expect, m);
  }

  @Test
  public void testProcess3() throws Exception {
    int[][] m = {{0, 2}, {4, 0}};
    ZeroMatrix.makeZeros(m);
    int[][] expect = {{0, 0}, {0, 0}};
    ArrayUtils.assertMatrixEquals(expect, m);
  }
}