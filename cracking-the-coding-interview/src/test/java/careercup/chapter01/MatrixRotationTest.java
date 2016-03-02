package careercup.chapter01;

import com.ahalikov.toolkit.utils.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link MatrixRotation}
 *
 * Created by akhalikov on 31/01/16
 */
public class MatrixRotationTest {
  @Test
  public void testRotate() throws Exception {
    System.out.println("Test rotate()");
    int[][] matrix = {
      {0, 1, 1, 3},
      {3, 2, 10, 11},
      {-4, 0, 0, 0},
      {2, 2, 1, -9}
    };
    ArrayUtils.print(matrix);

    System.out.println("Rotated:");
    int[][] result = MatrixRotation.rotate(matrix);
    ArrayUtils.print(result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRotateEmptyMatrix() throws Exception {
    int[][] matrix = {};
    MatrixRotation.rotate(matrix);
  }

  @Test
  public void testRotateInPlace() throws Exception {
    System.out.println("Test rotateInPlace()");
    int[][] matrix = {
      {0, 1, 1, 3},
      {3, 2, 10, 11},
      {-4, 0, 0, 0},
      {2, 2, 1, -9}
    };
    ArrayUtils.print(matrix);

    System.out.println("Rotated:");
    MatrixRotation.rotateInPlace(matrix);
    ArrayUtils.print(matrix);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRotateInPlaceEmptyMatrix() throws Exception {
    int[][] matrix = {};
    MatrixRotation.rotate(matrix);
  }
}