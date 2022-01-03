package chapter01;

import org.junit.Test;

import static chapter01.ZeroMatrix.makeZeros;
import static toolkit.utils.ArrayUtils.assertMatrixEquals;

public class ZeroMatrixTest {

    @Test
    public void testProcess1() {
        // given
        var matrix = new int[][]{{1, 2, 3}, {5, 0, 4}, {1, 2, 3}};
        var expect = new int[][]{{1, 0, 3}, {0, 0, 0}, {1, 0, 3}};

        // when
        makeZeros(matrix);

        // then
        assertMatrixEquals(expect, matrix);
    }

    @Test
    public void testProcess2() {
        // given
        var matrix = new int[][]{{1, 2, 3}, {5, 0, 4}, {1, 2, 0}};
        var expect = new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        // when
        makeZeros(matrix);

        // then
        assertMatrixEquals(expect, matrix);
    }

    @Test
    public void testProcess3() {
        // given
        var matrix = new int[][]{{0, 2}, {4, 0}};
        var expect = new int[][]{{0, 0}, {0, 0}};

        // when
        makeZeros(matrix);

        // then
        assertMatrixEquals(expect, matrix);
    }
}