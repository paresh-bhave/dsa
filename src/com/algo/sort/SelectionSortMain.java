package com.algo.sort;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
 *
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.
 *
 * In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
 *
 * Complexity: O(n^2)
 */
public class SelectionSortMain {
  static void sort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      if (minIndex != i) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
      }
    }
  }
  
  static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(" arr[" + i +"] => " + arr[i]);
    }
  }
  
  public static void main(String[] args) {
    int[] arr = {2,3,48,95,65,100,78,53,47,49,36,50};
  
    System.out.println("---BEFORE SORT---");
    print(arr);
  
    System.out.println("\n---AFTER SORT---");
    sort(arr);
    print(arr);
  }
}
