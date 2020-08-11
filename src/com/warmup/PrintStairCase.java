package com.warmup;

/**
 *    #
 *   ##
 *  ###
 * ####
 *
 * given n = 4
 * print stair case like this
 */

public class PrintStairCase {
  static void staircase(int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= n; j++) {
        if (j >= n - i) {
          System.out.printf("#");
        } else {
          System.out.printf(" ");
        }
      }
      System.out.printf("\n");
    }
  }
  
  public static void main(String[] args) {
    staircase(6);
  }
}
