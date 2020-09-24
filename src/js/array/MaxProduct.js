/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */

function findMaxProduct(nums) {
  let curMax = nums[0],
      curMin = nums[0],
      max = curMax;

  for (let i = 1; i < nums.length; i++) {
    let tmp = curMax;
    curMax = Math.max(tmp * nums[i], Math.max(curMin * nums[i], nums[i]));
    curMin = Math.min(tmp * nums[i], Math.min(curMin * nums[i], nums[i]));
    max = Math.max(max, curMax);
  }

  return max;
}

console.log(findMaxProduct([2,3,-2,4]));
console.log(findMaxProduct([-2,0,-1]));
console.log(findMaxProduct([0,2]));
console.log(findMaxProduct([0]));
console.log(findMaxProduct([-2,3,-4]));
