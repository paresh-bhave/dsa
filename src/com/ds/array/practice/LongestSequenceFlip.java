package com.ds.array.practice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem seen in FAMG interviews
 *
 * Given arrays of 1s and 0s find longest sequence of 1s that can be achieved by flipping 0
 *
 * Input:                   Output:
 * [1,1,0,1,1,0,1,0,1,1] ==>   5
 * [1,1,0,1,1,1,1,0,1,1] ==>   7
 */

public class LongestSequenceFlip {
  static void findLongestSequence(int[] a) {
    ArrayList<Integer> list = new ArrayList<>();
    
    int s = 0;
  
    for (int i = 0; i < a.length; i++) {
      if (a[i] == 1) {
        s++;
        if (s > 0 && i == a.length-1) list.add(s);
      } else {
        if (s > 0) list.add(s);
        list.add(a[i]);
        s = 0;
      }
    }
    
    int m = 0;
    
    for (int i = 0; i < list.size(); i = i + 2) {
      int n = list.get(i);
      
      if ((i+1) < n) n += 1;
      if ((i+2) < list.size()) n += list.get(i+2);
      if (n > m) m = n;
    }
    list.forEach(System.out::print);
    System.out.println("Max sequence ==> " + m);
  }
  
  public static void main(String[] args) {
    int t1[] = {1,1,0,1,1,0,1,0,1,1};
    int t2[] = {1,1,0,1,1,1,1,0,1,1};
    
    findLongestSequence(t1);
    findLongestSequence(t2);
  }
}
