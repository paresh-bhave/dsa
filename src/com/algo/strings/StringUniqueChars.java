package com.algo.strings;

/**
 * Implement an algorithm to determine if a string has all unique characters What if you can not use additional data structures?
 *
 *
 */

public class StringUniqueChars {
  static boolean hasUnique(String str) {
    boolean charSet[] = new boolean[256];
  
    for (int i = 0; i < str.length(); i++) {
      int c = str.charAt(i);
      if (charSet[c]) return false;
      charSet[c] = true;
    }
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(hasUnique("delta"));
    System.out.println(hasUnique("gamma"));
    System.out.println(hasUnique("theta"));
  }
}
