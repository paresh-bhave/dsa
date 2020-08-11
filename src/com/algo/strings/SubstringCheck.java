package com.algo.strings;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of
 * another Given two strings, s1 and s2, write code to check if s2 is a rotation of s1
 * using only one call to isSubstring
 * i e , “waterbottle” is a rotation of “erbottlewat”
 *
 * Solution:
 * Do following check
 * 1. Check if length(s1) == length(s2) If not, return false
 * 2. Else, concatenate s1 with itself and see whether s2 is substring of the result
 *
 */

public class SubstringCheck {
  static int isSubstring(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    
    /* A loop to slide pat[] one by one */
    for (int i = 0; i <= n - m; i++) {
      int j;
      for (j = 0; j < m; j++)
        if (s2.charAt(i + j) != s1.charAt(j))
          break;
        
      if (j == m) return i;
    }
    return -1;
  }
  
  static boolean isRotation(String s1, String s2) {
    int length = s1.length();
    
    if (length == s2.length() && length > 0) {
      // Contact s1 and s1 within new buffer
      
      String s1Merged = s1 + s1;
      return isSubstring(s2, s1Merged) > -1;
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    System.out.println(isRotation("apple", "pleap"));
    System.out.println(isRotation("waterbottle", "erbottlewat"));
    System.out.println(isRotation("apple", "pineapple"));
    System.out.println(isRotation("just", "go"));
  }
}
