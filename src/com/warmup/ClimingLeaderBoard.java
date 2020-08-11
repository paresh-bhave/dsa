package com.warmup;

import java.io.*;
import java.util.*;

public class ClimingLeaderBoard {
  
  // Complete the ClimingLeaderBoard function below.
  static int[] climbingLeaderboard(int[] scores, int[] alice) {
  
    int ranks[] = new int[alice.length];
    
    HashSet<Integer> scoreSet = new HashSet<>();
  
    for (int score: scores) {
      scoreSet.add(score);
    }
    
    List<Integer> scoreList = new ArrayList<Integer>(scoreSet);
    
    Collections.sort(scoreList, Collections.reverseOrder());
  
    for (int i = 0; i < alice.length; i++) {
      int rank = alice.length;
      int j = 1;
      for (int k = 0; k < scoreList.size() && alice[i] <= scoreList.get(k); k++) {
        if (alice[i] == scoreList.get(k)) {
          j = k + 1;
          break;
        } else {
          j++;
        }
      }
      ranks[i] = j;
    }
  
    System.out.println(Arrays.toString(ranks));
    return ranks;
  }
  
  private static final Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args) throws IOException {
  
    int scores[] = {100, 100, 50, 40, 40, 20, 10};
    int alice[] = {5, 25, 50, 120};
  
    int scores1[] = {100, 90, 90, 80, 75, 60};
    int alice1[] = {50, 65, 77, 90, 102};
    
    climbingLeaderboard(scores, alice);
    climbingLeaderboard(scores1, alice1);
  }
}
