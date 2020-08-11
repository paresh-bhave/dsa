package com.warmup;

/**
 * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with  places after the decimal.
 */

public class PlusMinus {
  static void plusMinus(int[] arr) {
    double p = 0, n = 0, z = 0;
  
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > 0) {
        p++;
      } else if (arr[i] < 0) {
        n++;
      } else {
        z++;
      }
    }
    
    System.out.printf("%.6f\n", (p / arr.length));
    System.out.printf("%.6f\n", (n / arr.length));
    System.out.printf("%.6f\n", (z / arr.length));

  }
  
  public static void main(String[] args) {
    int input1[] = {1,1,0,-1,-1};
    int input2[] = {-4,3,-9,0,4,1};
    
    plusMinus(input1);
    plusMinus(input2);
  }
}
