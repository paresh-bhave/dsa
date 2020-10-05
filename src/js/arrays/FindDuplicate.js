/**
 * Given an array of integers nums containing n + 1 integers where each integer is in
 * the range [1, n] inclusive. There is only one duplicate number in nums, return this duplicate number.
 *
 * Follow-ups:
 * - How can we prove that at least one duplicate number must exist in nums?
 * - Can you solve the problem without modifying the array nums?
 * - Can you solve the problem using only constant, O(1) extra space?
 * - Can you solve the problem with runtime complexity less than O(n2)?
 *
 * Example:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Input: nums = [1,1]
 * Output: 1
 *
 * Input: nums = [1,1,2]
 * Output: 1
 *
 * Source: https://leetcode.com/problems/find-the-duplicate-number/
 */


/**
 * Approach 1: Using set
 * - Create a set
 * - Iterate over the map
 *   - If number exists into set, return true
 *   - Else store it into set
 *
 * Explaination: Since there's only one duplicate in the array, set will find it as first occurences are stored into set
 *
 * Complexity: O(n)
 * Space: O(n)
 */

function findDuplicate(nums) {
  let set = new Set();

  for (let i = 0; i < nums.length; i++) {
    if (set.has(nums[i])) return nums[i];
    else set.add(nums[i]);
  }

  return -1;
}

console.log( findDuplicate([1,3,4,2,2]) );
console.log( findDuplicate([3,1,3,4,2]) );
console.log( findDuplicate([1,1]) );
console.log( findDuplicate([1,1,2]) );


/**
 * Approach 2: Cyclic Sort
 * - Iterate over array
 *   - If number is not at right index, swap it with right index e.g. nums[0] = 3 must be at nums[3-1] (index is 0 and range is 1 - n)
 * - After iteration, duplicate number will appear at last
 *
 * Explaination:
 * Since array will always contain n + 1 integers and range is from 1 to n, we can assume the numbers can be swapped to it's right index. After iteration duplicated number will be left at the n - 1 index as rest of the numbers are already in right index
 */

function findDuplicateCyclic(nums) {
  let i = 0;
  while (i < nums.length) {
    let curr = nums[i] - 1;
    if (nums[i] > 0 && nums[i] <= nums.length && nums[i] !== nums[curr]) {
      let temp = nums[i];
      nums[i] = nums[curr];
      nums[curr] = temp;
    } else {
      i++;
    }
  }
  return nums[nums.length - 1];
}

console.log( findDuplicateCyclic([1,3,4,2,2]) );
console.log( findDuplicateCyclic([3,1,3,4,2]) );
console.log( findDuplicateCyclic([1,1]) );
console.log( findDuplicateCyclic([1,1,2]) );


/**
 * Approach 3:
 *
 * - Iterate over array
 *   - If number at its index is less than 0, return the number
 *   - If number at its number is greater than 0, negate it
 *
 * Explaination:
 * If number at its actual index hasn't occurred it previously, it will have its orignal value and will be greater than 0, hence we negate so next time when its occurred, its value would be less than 0
 */

function findDuplicateCompare(nums) {
  for (let i = 0; i < nums.length; i++) {
    if(nums[Math.abs(nums[i]) - 1] < 0) return Math.abs(nums[i]);
    if(nums[Math.abs(nums[i]) - 1] > 0) nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
  }
}
console.log( findDuplicateCompare([1,3,4,2,2]) );
console.log( findDuplicateCompare([3,1,3,4,2]) );
console.log( findDuplicateCompare([1,1]) );
console.log( findDuplicateCompare([1,1,2]) );
