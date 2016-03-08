package chapter08.robot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Applying memoization for {@link RobotInAGrid1}
 */
public class RobotInAGrid2 {

  private static Map<Point, Boolean> cache;

  static List<Point> findPath(boolean[][] grid) {
    if (grid == null || grid.length == 0)
      return null;

    List<Point> path = new ArrayList<>();
    cache = new HashMap<>();

    int lastRow = grid.length-1;
    int lastCol = grid[0].length-1;

    return
      getPath(grid, lastRow, lastCol, path) ? path : null;
  }

  static boolean getPath(boolean[][] grid, int row, int col, List<Point> path) {
    if (col < 0 || row < 0 || !grid[row][col])
      return false;

    Point point = new Point(row, col);
    if (cache.containsKey(point))
      return cache.get(point);

    boolean success = false;
    if (point.isOrigin()
      || getPath(grid, row, col-1, path)
      || getPath(grid, row-1, col, path)) {
      path.add(point);
      success = true;
    }
    cache.put(point, success);
    return success;
  }
}
