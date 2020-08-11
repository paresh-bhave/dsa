package com.algo.strings;

/**
 * Write code to reverse a C-Style String (C-String means that “abcd” is represented as five characters, including the null character )
 */

public class ReverseCStyleString {
  static void cReverse(String str) {
    String sNull = str + " ";
    char c[] = sNull.toCharArray();
    char tmp;
    int i = 0,
        j = c.length - 1;
    
    while (i < j) {
      tmp = c[i];
      c[i] = c[j];
      c[j] = tmp;
      i++;
      j--;
    }
    String s1 = new String(c);
    System.out.println(s1);
  }
  
  public static void main(String[] args) {
    cReverse("alpha");
    cReverse("beta");
    cReverse("gamma");
    cReverse("delta");
  }
}
