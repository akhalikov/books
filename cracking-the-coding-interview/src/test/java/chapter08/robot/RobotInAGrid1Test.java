package chapter08.robot;

import org.junit.Test;

/**
 * Test for {@link RobotInAGrid1}
 */
public class RobotInAGrid1Test {
  @Test
  public void testFindPath() {
    boolean[][] grid = GridUtil.createGrid(6, 5);

    grid[2][0] = grid[3][0] = false;
    grid[1][3] = false;
    grid[2][2] = false;
    grid[3][2] = grid[4][2] = grid[5][2] = false;
    grid[3][4] = false;

    GridUtil.print(grid);
  }
}