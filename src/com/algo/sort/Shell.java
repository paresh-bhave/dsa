package com.algo.sort;

/**
 * Idea behind shell sort is to move entries more than one position at a time by h-sorting the array.
 *
 * Complexity for (3x+1) increment: O(N 3/2)
 */

public class Shell {
  public static void sort(int[] arr) {
    int n = arr.length;
    int gap = 1;
    for (gap = 3*gap + 1; gap > 0; gap /= 3) {
      for (int i = gap; i < n; i++) {
        int temp = arr[i];
        int j = i;
        
        while (j >= gap && arr[j - gap] > temp) {
          arr[j] = arr[j - gap];
          j -= gap;
        }
        
        arr[j] = temp;
      }
    }
  }
}
