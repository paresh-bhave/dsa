package com.ds.array.practice;

import java.util.Arrays;

public class ArrayManipulation {
  static long arrayManipulation(int n, int[][] queries) {
    int[] arr = new int[n];
//    for (int i = 0; i < n; i++) {
//      arr[i] = 0;
//    }
  
    long max = arr[0];
    
    for (int i = 0; i < queries.length; i++) {
      int a = queries[i][0];
      int b = queries[i][1];
      int c = queries[i][2];
      
      if (1 <= a && a <= b && b <= n) {
        for (int j = a - 1; j <= b - 1; j++) {
          arr[j] = arr[j] + c;
          if (max < arr[j]) max = arr[j];
        }
      }
      System.out.println(Arrays.toString(arr) + " len " + arr.length);
    }
    
    return max;
  }
  
  public static void main(String[] args) {
    int test[][] = {
      {1, 5, 3},
      {4, 8, 7},
      {6, 9, 1}
    };
  
    System.out.println(arrayManipulation((2*10), test));
    
  }
}
