/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */

function threeSum(nums) {
  if (nums.length < 3) return [];

  nums.sort((a, b) => a - b);

  const list = {};
  const set = new Set();

  for (let i = 0; i < nums.length - 2; i++) {
    let left = i + 1,
        right = nums.length - 1;

    while(left < right) {
      let sum = nums[i] + nums[left] + nums[right];
      let key = `k_${nums[i]}${nums[left]}${nums[right]}`
      let triplet = [nums[i], nums[left], nums[right]];

      if (sum === 0 && !set.has(triplet)) {
        set.add(triplet);
        left++;
        right--;
      }
      else if (sum > 0) right--;
      else if (sum < 0) left++;
    }
  }

  console.log(set);

  let results = [];

  for (const key in list) {
    if (list.hasOwnProperty(key)) {
      results.push(list[key]);
    }
  }

  return results;
}

console.log(threeSum([-1,0,1,2,-1,-4]));
