package com.ds.array.practice;

import java.util.Arrays;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column is set to 0
 *
 * Solution:
 *
 * We keep track in two arrays all the rows with zeros and all the columns with zeros
 * We then make a second pass of the matrix and
 * set a cell to zero if its row or column is zero
 */

public class ZeroMatrix {
  static void print(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.printf("%d ", matrix[i][j]);
      }
      System.out.printf("\n");
    }
  }
  
  static void makeZeros(int[][] matrix) {
    int[] row = new int[matrix.length];
    int[] col = new int[matrix[0].length];
  
    for (int i = 0; i < row.length; i++) {
      for (int j = 0; j < col.length;j++) {
        if (matrix[i][j] == 0) {
          row[i] = 1;
          col[j] = 1;
        }
      }
    }
  
    System.out.println("Row ==> " + Arrays.toString(row));
    System.out.println("Col ==> " + Arrays.toString(col));
    
    // Set arr[j][i] to 0 if row is 0
    // Set arr[j][i] to 0 if col is 0
    for (int i = 0; i < row.length; i++) {
      for (int j = 0; j < col.length; j++) {
        if (row[j] == 1) {
          matrix[j][i] = 0;
        }
        if (col[j] == 1) {
          matrix[i][j] = 0;
        }
      }
    }
    
    print(matrix);
  }
  
  public static void main(String[] args) {
    int[][] matrix = {
      {1, 0, 1, 1},
      {1, 1, 1, 1},
      {1, 1, 1, 1},
      {1, 1, 1, 0},
    };
    makeZeros(matrix);
  }
}
