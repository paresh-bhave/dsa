/**
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Source: https://leetcode.com/problems/jump-game-ii/
 *
 * Tag: #Google
 */

function jump(nums) {
  let position = 0;
      count = 0;
      distance = 0;

  for(let i = 0; i < nums.length-1; i++) {
    distance = Math.max(distance, nums[i]+i);

    if(i == position) {
      position = distance;
      count++;
    }
  }
  return count;
}

console.log( jump([2,3,1,1,4]) );
