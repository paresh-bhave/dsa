package com.algo.strings;

/**
 * Write a method to decide if two strings are anagrams or not
 *
 * Anagram == An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once
 */

public class AnagramStrings {
  
  static String sort(char charArr[]) {
    int temp,
        size = charArr.length;
    for(int i = 0; i < size; i++ ) {
      for(int j = i + 1; j < size; j++) {
        if(charArr[i] > charArr[j]) {
          temp = charArr[i];
          charArr[i] = charArr[j];
          charArr[j] = (char) temp;
        }
      }
    }
    return new String(charArr);
  }
  
  static boolean isAnagram(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    String s1Sorted = sort(s1.toCharArray());
    String s2Sorted = sort(s2.toCharArray());
    return s1Sorted.equals(s2Sorted);
  }
  
  public static void main(String[] args) {
    System.out.println(isAnagram("fired", "fried"));
    System.out.println(isAnagram("a gentleman", "elegant man"));
    System.out.println(isAnagram("a gentleman", "elegant man"));
    System.out.println(isAnagram("eleven plus two", "twelve plus one"));
    System.out.println(isAnagram("random thoughts", "chaotic mind"));
  }
}
