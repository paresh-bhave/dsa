package com.warmup;

public class FindSquares {
  static boolean isPerfectSquare(int n) {

    return false;
  }
  
  static int squares(int a, int b) {
    int count = 0;
  
    if (a < b) {
      for (int i = a; i <= b; i++) {
        double sr = Math.sqrt(i);
        double r = sr % 10;
        if (r == (int) r) {
          count++;
        }
      }
    }
    return count;
  }
  
  static int squares2(int a, int b) {
    int count = 0;
  
    for (int i = a; i <= b; i++) {
      double sr = Math.sqrt(i);
      if ((sr - Math.floor(sr)) == 0) {
        count++;
      }
    }
  
    return count;
  }
  
  public static void main(String[] args) {
    long time = System.nanoTime();
//      System.out.println(squares(3, 9));
//      System.out.println(squares(17, 24));
//      System.out.println(squares(100, 1000));
//      System.out.println(squares(35, 70));
      System.out.println(squares2(465868129, 988379794));
    System.out.println(System.nanoTime() - time);
  }
}
