package chapter01;

import org.junit.Test;

import static chapter01.MatrixRotation.rotate;
import static chapter01.MatrixRotation.rotateInPlace;
import static toolkit.utils.ArrayUtils.print;

public class MatrixRotationTest {

    @Test
    public void testRotate() {
        System.out.println("Test rotate()");
        var matrix = new int[][]{
            {0, 1, 1, 3},
            {3, 2, 10, 11},
            {-4, 0, 0, 0},
            {2, 2, 1, -9}
        };
        print(matrix);

        System.out.println("Rotated:");
        var result = rotate(matrix);
        print(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRotateEmptyMatrix() {
        int[][] matrix = {};
        rotate(matrix);
    }

    @Test
    public void testRotateInPlace() {
        System.out.println("Test rotateInPlace()");
        var matrix = new int[][]{
            {0, 1, 1, 3},
            {3, 2, 10, 11},
            {-4, 0, 0, 0},
            {2, 2, 1, -9}
        };
        print(matrix);

        System.out.println("Rotated:");
        rotateInPlace(matrix);
        print(matrix);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRotateInPlaceEmptyMatrix() {
        int[][] matrix = {};
        rotate(matrix);
    }
}