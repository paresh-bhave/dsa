/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 *
 * Sample:
 * Input: [2,2,1]
 * Output: 1
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * Source: https://leetcode.com/problems/single-number/
 */

/**
 * Approach 1:
 * - Sort the array
 * - Maintain a variable sum
 * - Iterate over the array
 *   - If index is even, add it to sum
 *   - If index is odd, remove from he sum
 *  - return the sum
 *
 * Explaination: All the numbers that has appeared twice get added and removed from the sum leaving it with a number that is only appeared once
 *
 * Complexity: O(o log n)
 * Space: Doesn't need additional space
 */
function singleNums(nums) {
  nums.sort((a, b) => a - b);

  let sum = 0;

  for (let i = 0; i < nums.length; i++) {
    if (i % 2 === 0) sum += nums[i];
    else sum -= nums[i];
  }

  return sum;
}


// tests
console.log( singleNums([2,2,1]) );
console.log( singleNums([4,1,2,1,2]) );


/**
 * Approach 2: Using set
 * - Create a set
 * - Iterate over array
 *   - If number exists in the set, remove it
 *   - else add it to the set
 * - retun the 0 indexed element from the set
 *
 * Explaination: All the numbers that has appeared twice get added and removed from the set leaving the only single number
 *
 * Complexity: O(o log n)
 * Space: Needs additional space
 */
function singleNumsSet(nums) {
  const set = new Set();

  for (let i = 0; i < nums.length; i++) {
    if (set.has(nums[i])) set.delete(nums[i]);
    else set.add(nums[i]);
  }

  return Array.from(set)[0];
}

// tests
console.log( singleNumsSet([2,2,1]) );
console.log( singleNumsSet([4,1,2,1,2]) );
