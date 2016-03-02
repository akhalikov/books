package careercup.chapter01;

/**
 * Given an image represented by an NxN matrix,
 * where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees.
 * Can you do this in place?
 */
class MatrixRotation {
  /**
   * Time complexity: O(n^2)
   * Space complexity: O(n^2)
   */
  static int[][] rotate(int[][] matrix) {
    if (matrix == null)
      throw new NullPointerException("matrix is null");
    int n = matrix.length;
    if (n == 0)
      throw new IllegalArgumentException("matrix is empty");
    if (n != matrix[0].length)
      throw new IllegalArgumentException("matrix is not squared");
    int[][] res = new int[n][n];
    int rowOffset;
    for (int i = 0; i < n; i++) {
      rowOffset = n - i - 1;
      for (int j = 0; j < n; j++)
        res[j][rowOffset] = matrix[i][j];
    }
    return res;
  }

  /**
   * Time complexity: O(n^2)
   * Space complexity: O(1)
   * @param matrix
   */
  static void rotateInPlace(int[][] matrix) {
    if (matrix == null)
      throw new NullPointerException("matrix is null");

    int n = matrix.length;
    if (n == 0)
      throw new IllegalArgumentException("matrix is empty");

    if (n != matrix[0].length)
      throw new IllegalArgumentException("matrix is not squared");

    for (int layer = 0; layer < n/2; ++layer) {
      int first = layer;
      int last = n - 1 - layer;
      for (int i = first; i < last; ++i) {
        int offset = i - first;
        // save top
        int top = matrix[first][i];

        // left to top
        matrix[first][i] = matrix[last - offset][first];

        // bottom to left
        matrix[last - offset][first] = matrix[last][last - offset];

        // right to bottom
        matrix[last][last - offset] = matrix[i][last];

        // top to right
        matrix[i][last] = top;
      }
    }
  }
}
