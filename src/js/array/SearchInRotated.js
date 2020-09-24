/**
 * You are given an integer array nums sorted in ascending order, and an integer target.
 * Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * If target is found in the array return its index, otherwise, return -1.
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */

function searchInRotated(nums, target) {
  let length = nums.length,
      left = 0,
      right = length - 1,
      mid = 0;
  while(left <= right) {
    mid = Math.floor((left + right) / 2);

    if (nums[mid] === target) return mid;

    if (nums[left] <= nums[mid]) {
      if (target >= nums[left] && target < nums[mid])
        right = mid - 1;
      else
        left = mid + 1;
    } else {
      if (target > nums[mid] && target <= nums[right])
        left = mid + 1;
      else
        right = mid - 1;
    }
  }
  return -1;
}


console.log(searchInRotated([4,5,6,7,0,1,2], 0));
console.log(searchInRotated([1,3], 1));
