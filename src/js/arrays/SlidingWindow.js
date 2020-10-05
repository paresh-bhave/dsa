/**
 * Problem: Given an array of integers of size ‘n’. Our aim is to calculate the maximum sum of ‘k’ consecutive elements in
 * the array.
 *
 * Input: Arr = [100, 200, 300, 400], k = 2
 * Output: 700
 *
 * Approach: Sliding Window
 *
 * 1. We compute the sum of first k elements out of n terms using a linear loop and store the sum in variable windowSum.
 * 2. Then we will graze linearly over the array till it reaches the end and simultaneously keep track of maximum sum.
 * 3. To get the current sum of block of k elements just subtract the first element from the previous block and add the last
 * element of the current block .
 *
 * Complexity: O(n)
 *
 * Source: https://www.geeksforgeeks.org/window-sliding-technique/
 *
 * Tags: #Array #SlidingWindow
 */

function maxSum(arr, k) {
  if (arr.length < k) return -1;

  let max = 0;

  for (let i = 0; i < k; i++)
    max += arr[i];

  let windowSum = max;

  for (let i = k; i < arr.length; i++) {
    windowSum += arr[i] - arr[i - k];
    max = Math.max(max, windowSum);
  }

  return max;
}

console.log(maxSum([100, 200, 300, 400], 2));
console.log(maxSum([1, 4, 2, 10, 23, 3, 1, 0, 20], 4));
console.log(maxSum([2, 3], 3));
