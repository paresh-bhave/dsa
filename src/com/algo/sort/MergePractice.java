package com.algo.sort;

import java.util.Arrays;
import java.util.Random;

public class MergePractice {
  static void merge(int arr[], int left, int middle, int right) {
  
    /**
     * Find size of 2 sub-arrays
     */
  
    int sizeLeft = middle - left + 1;
    int sizeRight = right - middle;
  
    /**
     * Create auxiliary arrays
     */
    int[] arrLeft = new int[sizeLeft];
    int[] arrRight = new int[sizeLeft];
  
    /**
     * Copy left array into left
     */
    for (int i = 0; i < sizeLeft; i++) {
      arrLeft[i] = arr[left + i];
    }
  
    /**
     * Copy right array into right
     */
    for (int i = 0; i < sizeRight; i++) {
      arrRight[i] = arr[middle + i + 1];
    }
  
    /**
     * Initial indexes of subarrays
     */
    int i = 0, j = 0;
  
    /**
     * Initial index of merged subarray
     */
    int k = left;
    
    while (i < sizeLeft && j < sizeRight) {
      if (arrLeft[i] <= arrRight[j]) {
        arr[k] = arrLeft[i];
        i++;
      } else {
        arr[k] = arrRight[j];
        j++;
      }
      k++;
    }
  
    /**
     * Copy remaining elements of left if any
     */
    while (i < sizeLeft) {
      arr[k] = arrLeft[i];
      i++;
      k++;
    }
  
    /**
     * Copy remaining elements of right if any
     */
    while (j < sizeRight) {
      arr[k] = arrLeft[j];
      j++;
      k++;
    }
  }
  
  static void sort(int arr[], int left, int right) {
    if (left < right) {
      /**
       * Find middle
       */
      int middle = (left + right) / 2;
  
      /**
       * Sort first and second halves
       */
      sort(arr, left, middle);
      sort(arr, middle + 1, right);
  
      /**
       * Merge
       */
      merge(arr, left, middle, right);
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
