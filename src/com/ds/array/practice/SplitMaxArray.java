package com.ds.array.practice;

public class SplitMaxArray {
  static int splitArray(int[] nums, int m) {
    long sum = 0;
    for (int i : nums) {
      sum += i;
    }
    long lo = 0;
    long hi = sum;
    long min = sum;
    
    while (lo <= hi) {
      long mid = (hi-lo)/2 + lo;
      if (canSplit(nums,mid,m)) {
        min = mid;
        hi = mid-1;
      } else {
        lo = mid + 1;
      }
    }
    
    return (int) min;
  }
  
  static boolean canSplit(int[] nums, long max, int m) {
    int count = 0;
    int ctr = 0;
    
    while (count < m && ctr < nums.length) {
      long sum = 0;
      while (sum <= max && ctr < nums.length) {
        sum += nums[ctr];
        ctr++;
      }
      if (sum > max) { // start a new group at the last index
        ctr--;
      }
      count++;
    }
    
    // if count is less than m, than we can split it into m subarrays and are guaranteed to not have one with sum > max
    return count <= m && ctr == nums.length;
  }
  
  public static void main(String[] args) {
    int[] test = { 7, 2, 5, 10, 8 };
    System.out.println(splitArray(test, 2));
  }
}
