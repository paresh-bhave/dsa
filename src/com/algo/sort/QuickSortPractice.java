package com.algo.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSortPractice {
  
  static void swap(int[] arr, int from, int to) {
    int temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;
  }
  
  static int partition(int[] arr, int low, int high) {
    int pivot = high;
  
    /**
     * Index of smaller element
     */
    int i = low - 1;
  
    for (int j = low; j < high; j++) {
      /**
       * If current element is smaller than the pivot
       */
      if (arr[j] < pivot) {
        i++;
  
        /**
         * Swap arr[i] with arr[j]
         */
        swap(arr, i, j);
      }
      swap(arr,(i+1), high);
    }
    return i+1;
  }
  
  static void sort(int[] arr, int low, int high) {
    if (low < high) {
      /**
       * Place portioning index in right place
       */
      int pI = partition(arr, low, high);
  
      /**
       * Recursively sort elements before partition and after partition
       */
      sort(arr, low, pI - 1);
      sort(arr, pI + 1, high);
    }
  }
  
  public static void main(String[] args) {
    int arr[] = new int[1000];
  
    Random random = new Random();
    for (int i = 0; i < 1000; i++) {
      arr[i] = random.nextInt(10000);
    }
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));;
  }
}
