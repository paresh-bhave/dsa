package com.algo.strings;

/**
 * Write a method to replace all spaces in a string with ‘%20’
 */

public class StringReplace {
  /**
   * Java replace
   */
  static String replace(String str) {
    return str.replaceAll("\\s", "%20");
  }
  
  /**
   * replacing char array
   */
  static String replace(char[] str) {
    int i, newLength, spaceCount = 0;
  
    for (i = 0; i < str.length; i++) {
      if (str[i] == ' ') spaceCount++;
    }
  
    System.out.println("Spaces " + spaceCount);
    
    newLength = str.length + (spaceCount * 3);
    char[] newCharArr = new char[newLength];

    for (i = str.length - 1; i >= 0; i--) {
      if (str[i] == ' ') {
        newCharArr[newLength - 1] = '0';
        newCharArr[newLength - 2] = '2';
        newCharArr[newLength - 3] = '%';
        newLength = newLength - 3;
      } else {
        newCharArr[newLength - 1] = str[i];
        newLength = newLength - 1;
      }
    }
    
    return new String(newCharArr);
  }
  
  public static void main(String[] args) {
    System.out.println(replace("hello world"));
    
    String testStr = "Hello world of algorithms";
  
    System.out.println(replace(testStr.toCharArray()));
  }
}
