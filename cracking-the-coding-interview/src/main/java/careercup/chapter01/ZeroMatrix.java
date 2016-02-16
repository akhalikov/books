package careercup.chapter01;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column is set to 0.
 */
class ZeroMatrix {
  /**
   * Time complexity: O(mn)
   * Space complexity: O(n)
   * @param matrix
   * @return
   */
  static void makeZeros(int[][] matrix) {
    int rowsNum = matrix.length,
        colsNum = matrix[0].length;

    boolean[] row = new boolean[rowsNum];
    boolean[] column = new boolean[colsNum];
    for (int i = 0; i < rowsNum; i++) {
      for (int j = 0; j < colsNum; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          column[j] = true;
        }
      }
    }
    for (int i = 0; i < rowsNum; i++) {
      for (int j = 0; j < colsNum; j++) {
        if (row[i] || column[j])
          matrix[i][j] = 0;
      }
    }
  }

  /**
   * Time complexity: O(m n)
   * Space complexity: O(1)
   * @param matrix
   * @return
   */
  static void makeZeros2(int[][] matrix) {
    int rowsNum = matrix.length,
      colsNum = matrix[0].length;
    // check if first row has zeros
    boolean rowHasZero = false;
    for (int j = 0; j < rowsNum; j++) {
      if (matrix[0][j] == 0) {
        rowHasZero = true;
        break;
      }
    }
    // check if first column has zeros
    boolean colHasZero = false;
    for (int j = 0; j < colsNum; j++) {
      if (matrix[0][j] == 0) {
        colHasZero = true;
        break;
      }
    }
    // check for zeros in the rest of the array
    for (int i = 1; i < rowsNum; i++) {
      for (int j = 1; j < colsNum; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    // nullify rows based on values in first column
    for (int i = 1; i < rowsNum; i++) {
      if (matrix[i][0] == 0)
        nullifyRow(matrix, i);
    }
    // nullify columns based on values in first row
    for (int j = 1; j < rowsNum; j++) {
      if (matrix[j][0] == 0)
        nullifyColumn(matrix, j);
    }
    // nullify first row
    if (rowHasZero)
      nullifyRow(matrix, 0);

    // nullify first column
    if (colHasZero)
      nullifyColumn(matrix, 0);
  }

  static void nullifyRow(int[][] matrix, int row) {
    for (int j = 0; j < matrix[0].length; j++)
      matrix[row][j] = 0;
  }

  static void nullifyColumn(int[][] matrix, int col) {
    for (int i = 0; i < matrix[0].length; i++)
      matrix[i][col] = 0;
  }
}
