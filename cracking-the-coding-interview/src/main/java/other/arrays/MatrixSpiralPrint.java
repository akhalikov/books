package other.arrays;

import utils.Util;

/**
 *
 * Spiral printing of 2D matrix
 *
 * http://www.geeksforgeeks.org/amazon-interview-experience-set-246-for-sde-2/
 *
 * Created by akhalikov on 29/02/16
 */
public class MatrixSpiralPrint {

  static void printBySpiral(int[][] mtx) {
    if (mtx == null)
      return;

    int rowsNum = mtx.length,
        colsNum = mtx[0].length;

    if (rowsNum == 0 && colsNum == 0)
      return;

    int row = 0, col = 0;
    while (row < rowsNum && col < colsNum) {
      // print the first row
      for (int i = col; i < colsNum; i++)
        System.out.print(mtx[row][i] + " ");
      row++;

      // print the last column
      for (int i = row; i < rowsNum; i++)
        System.out.print(mtx[i][colsNum-1] + " ");
      colsNum--;

      // print the last row
      if (row < rowsNum) {
        for (int i = colsNum-1; i >= col; i--)
          System.out.print(mtx[rowsNum-1][i] + " ");
        rowsNum--;
      }

      // print the last column
      if (col < colsNum) {
        for (int i = rowsNum-1; i >= row; i--)
          System.out.print(mtx[i][col] + " ");
        col++;
      }
    }
  }

  public static void main(String[] args) {
    int[][] mtx = {
      {0, 2,  1,  3},
      {7, 2,  5,  10},
      {5, 11, 8,  4},
      {9, 12, 20, 3}
    };
    Util.print(mtx);
    System.out.println("Spiral print:");
    MatrixSpiralPrint.printBySpiral(mtx);
  }
}
