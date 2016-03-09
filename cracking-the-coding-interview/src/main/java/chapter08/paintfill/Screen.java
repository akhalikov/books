package chapter08.paintfill;

import java.util.Random;

/**
 * Screen
 *
 * Created by akhalikov on 08/03/16
 */
public class Screen {
  private static final Random rand = new Random();

  private Color[][] pixels;
  private int rowsNum, colsNum;

  public static Screen createRandomScreen(int rows, int cols) {
    final Screen screen = new Screen();
    screen.rowsNum = rows;
    screen.colsNum = cols;
    screen.pixels = new Color[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        Color c = Color.getColorByNum(rand.nextInt(Color.Black.id + 1));
        screen.pixels[i][j] = c;
      }
    }
    return screen;
  }

  public Color colorAt(int row, int col) {
    return pixels[row][col];
  }

  /**
   * Change color at point (row,col) and return the old color
   * @return old color
   */
  public Color changeColor(int row, int col, Color newColor) {
    Color oldColor = pixels[row][col];
    pixels[row][col] = newColor;
    return oldColor;
  }

  public void print() {
    for (int i = 0; i < rowsNum; i++) {
      for (int j = 0; j < colsNum; j++) {
        System.out.print(pixels[i][j].id + " ");
      }
      System.out.println();
    }
  }

  public int getRowsNum() {
    return rowsNum;
  }

  public int getColsNum() {
    return colsNum;
  }
}
