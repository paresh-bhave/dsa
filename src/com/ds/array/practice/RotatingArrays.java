package com.ds.array.practice;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees Can you do this in place?
 *
 * Solution:
 * The rotation can be performed in layers, where you perform a cyclic swap on the edges on each layer
 * In the first for loop, we rotate the first layer (outermost edges) We rotate the edges by doing a four-way swap first on the corners,
 * then on the element clockwise from the edges, then on the element three steps away
 */

public class RotatingArrays {
  
  static void print(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        char prefix = matrix[i][j] < 10 ? '0' : '\0';
        System.out.printf("%c%d ", prefix, matrix[i][j]);
      }
      System.out.printf("\n");
    }
  }
  
  static void rotate(int[][] matrix, int n) {
    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;
  
      for (int i = first; i < last; i++) {
        int offset = i - first;
        int top = matrix[first][i];
        
        // left ->  top
        matrix[first][i] = matrix[last - offset][first];

        // bottom -> left
        matrix[last-offset][first] = matrix[last][last - offset];
        
        // right -> bottom
        matrix[last][last - offset] = matrix[i][last];
        
        // top -> right
        matrix[i][last] = top; // right <- saved top
      }
    }
    print(matrix);
  }
  
  public static void main(String[] args) {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16},
    };
    rotate(matrix, matrix.length);
  }
}
