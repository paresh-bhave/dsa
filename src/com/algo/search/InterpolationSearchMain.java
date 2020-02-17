package com.algo.search;

import java.util.Arrays;

/**
 * Interpolation search may go to different locations according to the value of the key being searched.
 *
 * The idea of formula is to return higher value of pos
 * when element to be searched is closer to arr[hi]. And
 * smaller value when closer to arr[lo]
 *
 * pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]
 *
 * arr[] ==> Array where elements need to be searched
 * x     ==> Element to be searched
 * lo    ==> Starting index in arr[]
 * hi    ==> Ending index in arr[]
 *
 * Rest of the Interpolation algorithm is the same except the above partition logic.
 *
 * In a loop, calculate the value of “pos” using the probe position formula.
 * If it is a match, return the index of the item, and exit.
 * If the item is less than arr[pos], calculate the probe position of the left sub-array. Otherwise calculate the same in the right sub-array.
 * Repeat until a match is found or the sub-array reduces to zero.
 *
 * Complexity: Ο(log (log n))
 */

public class InterpolationSearchMain {
  static int search(int[] arr, int x) {
    int low = 0;
    int high = arr.length - 1;
    
    while (low <= high && x >= arr[low] && x <= arr[high]) {
      if (low == high) {
        if (arr[low] == x) {
          return low;
        }
        return -1;
      }
      
      int pos = low + (((high - low) / (arr[high]-arr[low])) * (x - arr[low]));
      
      if (arr[pos] == x) {
        return pos;
      }
      if (arr[pos] < x) {
        low = pos + 1;
      } else {
        high = pos - 1;
      }
    }
    return -1;
  }
  
  public static void main(String[] args) {
    int[] arr = {2,3,48,95,65,100,78,53,47,49,36,50};
  
    Arrays.sort(arr);
  
    int result = search(arr,65);
  
    if (result == -1) {
      System.out.println("Element is not present in the array");
    } else {
      System.out.println("Element is found at index: " + result);
    }
  }
}
