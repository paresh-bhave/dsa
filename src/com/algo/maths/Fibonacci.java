package com.algo.maths;

import java.util.ArrayList;
import java.util.HashMap;

public class Fibonacci {
  private static HashMap<Integer, Integer> map = new HashMap<>();
  
  static int fibb(int n) {
    if (n <= 1) return n;
  
    if (map.containsKey(n)) {
      System.out.printf("grabbing memo[%d]\n", n);
      return map.get(n);
    }
  
    System.out.printf("computing fib(%d)\n", n);
    int result = fibb(n - 1) + fibb(n - 2);
  
    // memoize
    map.put(n, result);
    return result;
  }
  
  public static void main(String[] args) {
    System.out.println(fibb(5));
  }
}
