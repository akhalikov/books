package chapter08.robot;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a robot sitting on the upper left corner of grid
 * with r rows and c columns.
 *
 * The robot can only move in two directions, right and down,
 * but certain cells are "off limits" such that the robot cannot step on them.
 * Design and algorithm to find a path for the robot from the top left to the bottom right.
 *
 * Recursive top-down approach: to find a path to (r,c) we look for a path to an
 * adjacent coordinate (r-1,c) or (r,c-1). If one of those squares is off limits,
 * we ignore it. Then look at their adjacent coordinates:
 *  (r-2,c), (r-1,c-1), (r-1,c-1), and (r,c-2).
 *
 * Time complexity: O(2^(r+c))
 */
public class RobotInAGrid1 {

  static List<Point> findPath(boolean[][] grid) {
    if (grid == null || grid.length == 0)
      return null;

    List<Point> path = new ArrayList<>();
    int finishR = grid.length-1;
    int finishC = grid[0].length-1;
    if (getPath(grid, finishR, finishC, path)) {
      return path;
    }
    return null;
  }

  static boolean getPath(boolean[][] grid, int row, int col, List<Point> path) {
    if (col < 0 || row < 0 || !grid[row][col])
      return false;

    Point point = new Point(row, col);
    if (point.isOrigin()
      || getPath(grid, row, col-1, path)
      || getPath(grid, row-1, col, path)) {
      path.add(point);
      return true;
    }
    return false;
  }
}