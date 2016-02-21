package careercup.chapter08.robot;

/**
 * Grid point
 */
public class Point {
  int row;
  int col;

  public Point(int row, int col) {
    this.row = row;
    this.col = col;
  }

  boolean isOrigin() {
    return row == 0 && col == 0;
  }
}
