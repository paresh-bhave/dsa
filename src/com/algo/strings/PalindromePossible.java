package com.algo.strings;

/**
 * Can a string be a palindrome by just removing one character
 */

public class PalindromePossible {
  
  static boolean isPalindrome(String str, int low, int high) {
    while (low < high) {
      if (str.charAt(low) != str.charAt(high))
        return false;
      low++;
      high--;
    }
    return true;
  }
  
  static boolean canBePalindrome(String str) {
    // Initialize low and right
    // by both the ends of the string
    int low = 0, high = str.length() - 1;
  
    // loop until low and
    // high cross each other
    
    while (low < high) {
      // If both characters are equal then
      // move both pointer towards end
      if (str.charAt(low) == str.charAt(high)) {
        low++;
        high--;
      } else {
      
        /*
         * If removing str[low] makes the
         * whole string palindrome. We basically
         * check if substring str[low+1..high]
         * is palindrome or not.
         */
        if (isPalindrome(str, low + 1, high))
          return true;
      
        /*
         * If removing str[high] makes the whole string
         * palindrome. We basically check if substring
         * str[low+1..high] is palindrome or not.
         */
        if (isPalindrome(str, low, high - 1))
          return true;
        return false;
      }
    }
    return false;
  }
  
  public static void main(String[] args) {
    System.out.println(canBePalindrome("abcdba"));
    System.out.println(canBePalindrome("wordodorw"));
    System.out.println(canBePalindrome("abdcddcba"));
  }
}
