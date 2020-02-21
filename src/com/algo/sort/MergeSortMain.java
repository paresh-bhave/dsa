package com.algo.sort;

/**
 * Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides input array in two halves, calls itself for the two halves and then merges the two sorted halves. The merge() function is used for merging two halves. The merge(arr, l, m, r) is key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.
 */

public class MergeSortMain {
  static void merge(int arr[], int left, int middle, int right) {
    int sizeLeft = middle - left + 1;
    int sizeRight = right - middle;
    
    int arrLeft[] = new int[sizeLeft];
    int arrRight[] = new int[sizeRight];
  
    for (int i = 0; i < sizeLeft; i++) {
      arrLeft[i] = arr[left + i];
    }
  
    for (int j = 0; j < sizeRight; j++) {
      arrRight[j] = arr[middle + 1 + j];
    }
    
    int i = 0,
        j = 0,
        k = left;
    
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
    
    while (i < sizeLeft) {
      arr[k] = arrLeft[i];
      i++;
      k++;
    }
  
    while (j < sizeRight) {
      arr[k] = arrRight[j];
      j++;
      k++;
    }
  }
  
  static void sort(int arr[], int left, int right) {
    if (left < right) {
      int middle = (left + right) / 2;
      sort(arr, left, middle);
      sort(arr , middle + 1, right);
      merge(arr, left, middle, right);
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
    sort(arr, 0, arr.length - 1);
    print(arr);
  }
}
