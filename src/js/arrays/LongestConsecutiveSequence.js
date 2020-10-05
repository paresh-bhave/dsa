/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Source: https://leetcode.com/problems/longest-consecutive-sequence/
 */

/**
 * Approach 1: Naive - Sort and Compare
 *
 * - Sort the array
 * - Maintain two variables to count and compare current streak count and longest streak count
 * - Iterate over the array (starting from one)
 *   - If current number is not equals to previous number
 *     - If current number is exactly equals to prev num + 1, then increase current count
 *     - else choose max b/e current streak count and longest streak count, reset current streak count to 1
 *
 * Explanation:
 * We iterate over the numbers in ascending order, then its easy to find sequences of consecutive numbers.
 * To do so, we can sort the array.
 *
 * Time Complexity: O(ologn);
 * Space Complexity: O(1)
 */

function longestConsecutive(nums) {
  if (nums.length === 0) return 0;

  nums.sort((a, b) =>  a - b);

  let longestStreak = 1,
      currentStreak = 1;

  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== nums[i-1]) {
      if (nums[i] === nums[i - 1] + 1) {
        currentStreak += 1;
      } else {
        longestStreak = Math.max(longestStreak, currentStreak);
        currentStreak = 1;
      }
    }
  }

  return Math.max(longestStreak, currentStreak);
}

// Tests
console.log( longestConsecutive([100, 4, 200, 1, 3, 2])  );
console.log( longestConsecutive([11,21,31,12,22,32,13,23,33,34,24,25,35,36,37]) );


/**
 * Approach 2: HashSet and Sequence Building
 *
 *
 * Time Complexity: O(n);
 * Space Complexity: O(n)
 */

function longestConsecutiveSet(nums) {
  const set = new Set();

  for (let i = 0; i < nums.length; i++)
    set.add(nums[i]);

  let longestStreak = 0;

  for(let num of set) {
    if (!set.has(num-1)) {
      let currentNum = num;
      let currentStreak = 1;

      while(set.has(currentNum + 1)) {
        currentNum += 1;
        currentStreak += 1;
      }

      longestStreak = Math.max(longestStreak, currentStreak);
    }
  }

  return longestStreak;
}

// Tests
console.log( longestConsecutiveSet([100, 4, 200, 1, 3, 2])  );
console.log( longestConsecutiveSet([11,21,31,12,22,32,13,23,33,34,24,25,35,36,37]) );
