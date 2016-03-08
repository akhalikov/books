package chapter08.robot;

/**
 * Created by akhalikov on 22/02/16
 */
public class GridUtil {

  static boolean[][] createGrid(int rows, int cols) {
    boolean[][] grid = new boolean[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++)
        grid[i][j] = true;
    }
    return grid;
  }

  static void print(boolean[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        System.out.print((grid[i][j] ? 1: 0) + " ");
      }
      System.out.println();
    }
  }
}
