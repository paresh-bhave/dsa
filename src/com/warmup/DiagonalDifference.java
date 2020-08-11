package com.warmup;

/**
 * Given a square matrix, calculate the absolute difference between the sums of its diagonals.
 */

import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {
  public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
  
    int d1 = 0;
    int d2 = 0;
    
    for (int i = 0; i < arr.size(); i++) {
      List<Integer> row = arr.get(i);
      for (int j = 0; j < row.size(); j++) {
        if (i == j) {
          d1 += row.get(j);
        }
        if (i + j == arr.size() - 1) {
          d2 += row.get(j);
        }
      }
    }
    return Math.abs((d1 - d2));
  }
  
  public static void main(String[] args) {
    List<Integer> r1 = new ArrayList<>();
    r1.add(11);
    r1.add(2);
    r1.add(4);
  
    List<Integer> r2 = new ArrayList<>();
    r2.add(4);
    r2.add(5);
    r2.add(6);
    
    List<Integer> r3 = new ArrayList<>();
    r3.add(10);
    r3.add(8);
    r3.add(-12);
  
    List<List<Integer>> m = new ArrayList<>();
    m.add(r1);
    m.add(r2);
    m.add(r3);
  
    System.out.println(diagonalDifference(m));
  }
}
