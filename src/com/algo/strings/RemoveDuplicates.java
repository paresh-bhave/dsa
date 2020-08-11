package com.algo.strings;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer NOTE: One or two additional variables are fine An extra copy of the array is not
 *
 * 2 Approaches:
 *  - using additional time
 *  - using constant buffer
 */

public class RemoveDuplicates {
  
  /**
   * time trade O(n2)
   * @param str
   */
  static void noDuplicates(String str) {
    int len = str == null ? 0 : str.length();
    if (len <= 1) return;
    int tail = 1;
    
    char charArr[] = str.toCharArray();
  
    for (int i = 1; i < len; i++) {
      int j;
      for (j = 0; j < tail; j++) {
        if (charArr[i] == charArr[j]) break;
      }
      if (j == tail) {
        charArr[tail] = charArr[i];
        ++tail;
      }
    }
    for (int i = tail; i < len; i++) {
      charArr[i] = 0;
    }
    String s = new String(charArr);
    System.out.println(s);
  }
  
  /**
   * Space trade O(n2)
   * @param str
   */
  static void noDuplicatesBuff(String str) {
    int len = str == null ? 0 : str.length();
    if (len <= 1) return;
    int tail = 1;
  
    char charArr[] = str.toCharArray();
    
    boolean hit[] = new boolean[256];
  
    for (int i = 0; i < hit.length; i++) {
      hit[i] = false;
    }
    
    hit[charArr[0]] = true;
    for (int i = 1; i < len; ++i) {
      if (!hit[charArr[i]]) {
        charArr[tail] = charArr[i];
        ++tail;
        hit[charArr[i]] = true;
      }
    }
  
    for (int i = tail; i < len; i++) {
      charArr[i] = 0;
    }
    String s = new String(charArr);
    System.out.println(s);
  }
  
  public static void main(String[] args) {
    noDuplicates("");
    noDuplicates("hello");
    noDuplicates("casablanca");
  
    noDuplicatesBuff("hello");
    noDuplicatesBuff("casablanca");
  }
}
