package com.ds.array.practice;

/**
 * Problem seen in FAMG interviews
 *
 * Given 2D (N x M) array, re-arrange / print elements in spiral order
 *
 * e.g.
 *  [-] [-] [-] [->]
 *  [|][-][->][|]
 *  [|][<-][|][|]
 *  [<-][-][-][|]
 */

public class SpiralMatrix {
  static void printArr(int[][] arr) {
    int firstRow = 0,
        lastRow = arr.length - 1,
        firstCol = 0,
        lastCol = arr[0].length - 1;
    
    while (firstRow < lastRow && firstCol < lastCol) {
  
      for (int i = firstCol; i <= lastCol; i++) {
        System.out.print(arr[firstRow][i] + " ");
      }
      for (int i = firstRow + 1; i <= lastRow; i++) {
        System.out.print(arr[i][lastCol] + " ");
      }
      for (int i = lastCol - 1; i > firstCol; i--) {
        System.out.print(arr[lastRow][i] + " ");
      }
      for (int i = lastRow - 1; i > firstCol; i--) {
        System.out.print(arr[i][firstCol] + " ");
      }
      
      firstRow++;
      lastRow--;
      firstCol++;
      lastCol--;
    }
  }
  
  public static void main(String[] args) {
    int arr[][] = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };
    printArr(arr);
  }
}
