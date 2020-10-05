/**
 * Problem: Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers
 * which has the largest sum.
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Approach: (Kadane’s Algorithm)
 *
 * 1. Initialize:
 *    max = 0;
 *    currMax = 0;
 *
 * 2. Iterate over each element of the array
 *  a) currMax = currMax + arr[i]
 *  b) if max < currMax
 *        max = currMax
 *  c) if currMax < 0
 *        currMax = 0
 *
 * return max;
 *
 * Source: https://en.wikipedia.org/wiki/Maximum_subarray_problem
 *
 * Tags: #Array #MaxSubArray #TwoPointers
 */

function findMaxSum(arr) {
  let max = -Infinity,
      currMax = 0;

  for (let i = 0; i < arr.length; i++) {
    currMax = Math.max(currMax + arr[i], nums[i]);
    max = Math.max(currMax, max);
  }

  return max;
}


console.log(findMaxSum([-2, -3, 4, -1, -2, 1, 5, -3]));
console.log(findMaxSum([1, 2, 3, 4, 5]));
console.log(findMaxSum([-1, -2, -3, -4, -5]));


/**
 * Problem: The problem is to find the sum of the elements of the contiguous subarray having the smallest(minimum) sum.
 *
 * Input: nums = [3, -4, 2, -3, -1, 7, -5]
 * Output: -6
 * Explanation: [-4, 2, -3, -1] has the smallest sum = 6.
 *
 * Approach: (Modified Kadane’s Algorithm)
 *
 * 1. Initialize:
 *    min = INT_MAX;
 *    currMin = INT_MAX;
 *
 * 2. Iterate over each element of the array
 *  a) if currMin > 0
 *        currMin = currMin + arr[i]
 *  b) else
 *        currMin += arr[i]
 *  c) min = min(min, currMin)
 *
 * return max;
 *
 * Source: https://www.geeksforgeeks.org/smallest-sum-contiguous-subarray/#:~:text=The%20subarray%20having%20the%20smallest,the%20idea%20of%20Kadane's%20algorithm.
 *
 * Tags: #Array #MinSubArray
 */


function findMinSum(arr) {
  /**
   * set min to INT_MAX. Alternatively can also do Math.max(...arr) in JS
   */
  let min = 2147483647,
      currMin = 2147483647;

  for (let i = 0; i < arr.length - 1; i++) {
    if (currMin > 0) currMin = arr[i];
    else currMin += arr[i];
    min = Math.min(currMin, min);
  }

  return min;
}

console.log(findMinSum([3, -4, 2, -3, -1, 7, -5]));
console.log(findMinSum([-1, -2, -3, -4, -5]));
console.log(findMinSum([0, 1, 2, 3, 4, 5]));
