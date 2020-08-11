package com.warmup;

/**
 * You have a string of lowercase English alphabetic letters. You can perform two types of operations on the string:
 *
 * Append a lowercase English alphabetic letter to the end of the string.
 * Delete the last character in the string. Performing this operation on an empty string results in an empty string.
 * Given an integer, k, and two strings, s and t, determine whether or not you can convert s to t by performing exactly k of the above operations on s. If it's possible, print Yes. Otherwise, print No.
 *
 * For example, strings s ="abc"  and t="def". Our number of moves, k = 6. To convert s to t, we first delete all of the characters in 3 moves. Next we add each of the characters of t in order. On the 6th move, you will have the matching string. If there had been more moves available, they could have been eliminated by performing multiple deletions on an empty string. If there were fewer than 6 moves, we would not have succeeded in creating the new string.
 */

public class AppendAndDelete {
  static String appendAndDelete(String s, String t, int k) {
    int i = 0;
    while (i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i)) ++i;
  
    int toDelete = s.length() - i;
    int toAppend = t.length() - s.length() + toDelete;
  
    int total = toAppend + toDelete;
    
    if (k < total) {
      return "No";
    } else if ((k - total) % 2 == 0) {
      return "Yes";
    } else if (k > s.length() + t.length()) {
      return "Yes";
    } else {
      return "No";
    }
  }
  
  public static void main(String[] args) {
    System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
    System.out.println(appendAndDelete("ashley", "ash", 2));
  }
}
