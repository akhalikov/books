package chapter08.paintfill;

/**
 * Implement the paintFill function that one might see on many image editing programs.
 * That is, given a screen (represented by a 2-dimensional array of colors),
 * a point, and a new color, fill in the surrounding area until the color changes
 * from the original color.
 *
 * Created by akhalikov on 07/03/16
 */
public class PaintFill {

  static boolean paintFill(Screen screen,
                        int row, int col, Color newColor) {
    if (screen == null)
      throw new NullPointerException("screen is null");

    return paintFill(screen, row, col, newColor, screen.colorAt(row, col));
  }

  private static boolean paintFill(Screen screen,
                                   int row, int col,
                                   Color newColor, Color oldColor) {
    if (row < 0 || row >= screen.getRowsNum()
      || col < 0 || col >= screen.getColsNum())
      return false;

    if (screen.colorAt(row, col) == oldColor) {
      screen.changeColor(row, col, newColor);
      paintFill(screen, row-1, col, newColor, oldColor);
      paintFill(screen, row+1, col, newColor, oldColor);
      paintFill(screen, row, col-1, newColor, oldColor);
      paintFill(screen, row, col+1, newColor, oldColor);
    }
    return true;
  }
}
