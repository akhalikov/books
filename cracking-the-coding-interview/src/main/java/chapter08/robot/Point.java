package chapter08.robot;

/**
 * Grid point
 */
class Point {
  int row;
  int col;

  Point(int row, int col) {
    this.row = row;
    this.col = col;
  }

  boolean isOrigin() {
    return row == 0 && col == 0;
  }
}
