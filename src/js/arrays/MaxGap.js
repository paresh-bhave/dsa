/**
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Return 0 if the array contains less than 2 elements.
 *
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
 *
 * Source: https://leetcode.com/problems/maximum-gap/
 */
function maxGap(arr) {
  if (arr.length < 2) return 0;

  arr.sort((a, b) => a - b);

  let max = 0;

  for (let i = 1; i < arr.length; i++)
    max = Math.max(arr[i] - arr[i - 1], max);

  return max;
}

console.log( maxGap([3,5,4,2]) );
console.log( maxGap([3,6,9,1]) );
console.log( maxGap([0]) );
console.log( maxGap([0,1]) );
console.log( maxGap([1,10]) );


/**
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 *
 * Example:
 * Input:  A = [3, 5, 4, 2]
 * Output: 2
 * Source: https://www.interviewbit.com/problems/max-distance/
 */
function maxDistance(nums) {
  let map = {};

  let max = 0;

  for (let i = 0; i < nums.length; i++) {
    if (!map[nums[i]]) {
      map[nums[i]] = i
    }
  }

  console.log(map);
  // return max;
}

console.log( maxDistance([3,5,4,2]) );
console.log( maxDistance([3,6,9,1]) );
console.log( maxDistance([0]) );
console.log( maxDistance([0,1]) );
console.log( maxDistance([1,10]) );
