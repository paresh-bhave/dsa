package com.ds.array.practice;
import java.util.ArrayList;
import java.util.List;

public class DynamicArrayProblem {
  public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here
    List<List<Integer>> result = new ArrayList<List<Integer>>();
  
    for (int i = 0; i < n; i++) {
      result.add(new ArrayList<>());
    }
    
    int xor = 0;
    
    for(int i = 0; i < n; i++) {
      for (int j = 0; j < queries.size(); j++) {
        List<Integer> list = queries.get(j);
        
        int a = list.get(0);
        int x = list.get(1);
        int y = list.get(2);
        
        if (a == 1) {
          int t = (x^xor) % n;
          result.get(t).add(y);
        } else {
          int t = (x^xor) % n;
          xor = (int) result.get(t).get( (y % result.get(t).size()));
        }
      }
    }
  
    List<Integer> finalList = new ArrayList<>();
    
    for (int i = 0; i < result.size(); i++) {
      finalList.add(result.get(i).get(result.size()));
    }
    
    return finalList;
  }
  
  public static void main(String[] args) {
    //2 5
    //1 0 5
    //1 1 7
    //1 0 3
    //2 1 0
    //2 1 1
    
    List<Integer> q1 = new ArrayList<>();
    q1.add(1); q1.add(0); q1.add(5);
  
    List<Integer> q2 = new ArrayList<>();
    q2.add(1); q2.add(1); q2.add(7);
  
    List<Integer> q3 = new ArrayList<>();
    q3.add(1); q3.add(0); q3.add(3);
    
    List<Integer> q4 = new ArrayList<>();
    q4.add(2); q4.add(1); q4.add(0);
  
    List<Integer> q5 = new ArrayList<>();
    q5.add(2); q5.add(1); q5.add(1);
    
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    
    lists.add(q1);
    lists.add(q2);
    lists.add(q3);
    lists.add(q4);
    lists.add(q5);
    
    dynamicArray(2, lists);
  }
}
