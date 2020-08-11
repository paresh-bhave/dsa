package com.ds.array.practice;

import java.util.Arrays;

public class SparseArrays {
  static void matchingStrings(String[] strings, String[] queries) {
    int result[] = new int[queries.length];
  
    for (int i = 0; i < queries.length; i++) {
      result[i] = 0;
      for (int j = 0; j < strings.length; j++) {
        if (queries[i].equals(strings[j])) {
          result[i] += 1;
        }
      }
      System.out.println(result[i]);
    }
  }
  
  public static void main(String[] args) {
    String[] strings = {
      "abcde",
      "sdaklfj",
      "asdjf",
      "na",
      "basdn",
      "sdaklfj",
      "asdjf",
      "na",
      "asdjf",
      "na",
      "basdn",
      "sdaklfj",
      "asdjf"
    };
    String[] queries = {
      "abcde",
      "sdaklfj",
      "asdjf",
      "na",
      "basdn"
    };
    
    matchingStrings(strings, queries);
  }
}
