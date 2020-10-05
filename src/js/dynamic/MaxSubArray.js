/**
 * https://leetcode.com/problems/maximum-subarray/
 *
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
