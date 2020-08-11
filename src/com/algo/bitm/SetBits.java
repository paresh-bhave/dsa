package com.algo.bitm;

/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j Write a method to set all bits between i and j in N equal to M
 * (e g , M becomes a substring of N located at i and starting at j)
 *
 * EXAMPLE:
 * Input: N = 10000000000, M = 10101, i = 2, j = 6
 * Output: N = 10001010100
 */

public class SetBits {
  static int updateBits(int n, int m, int i, int j) {
    // all 1's
    int max = ~0;
    System.out.println("Max => " + max);
    
    // 1s through position j, then 0s
    int left = max - ((1 << j) - 1);
    System.out.println("Left => " + left);
  
    // 1’s after position i
    int right = ((1 << i) - 1);
    System.out.println("Right => " + right);
    
    // 1s, with 0s between i and j
    int mask = left | right;
    System.out.println("Mask => " + right);
  
    // Clear i through j, then put m in there
    return (n & mask) | (m << i);
  }
  
  public static void main(String[] args) {
    System.out.println("Updated => " + updateBits(1000000000, 10101, 2, 6));
  }
}
