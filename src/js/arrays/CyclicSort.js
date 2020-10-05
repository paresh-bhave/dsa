/**
 * Problem: Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Input: [1,2,0]
 * Output: 3
 *
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 * Approach: Cyclic Sort
 *
 * This pattern describes an interesting approach to deal with problems involving arrays containing numbers in a given range.
 * The Cyclic Sort pattern iterates over the array one number at a time, and if the current number you are iterating is not
 * at the correct index, you swap it with the number at its correct index.
 *
 * Complexity: O(n)
 *
 * Source:
 * 1. https://leetcode.com/problems/first-missing-positive/
 * 2. https://emre.me/coding-patterns/cyclic-sort/
 *
 * Tags: #Array #CyclicSort
 *
 * Note: Below JS code works for positive numbers only
 */

function findFirstMissingPositive(arr) {
  let i = 0;

  while (i < arr.length) {
    let abs = arr[i] - 1;
    if (arr[i] > 0 && arr[i] <= arr.length && arr[i] !== arr[abs]) {
      let temp = arr[i];
      arr[i] = arr[abs];
      arr[abs] = temp;
    } else {
      i++;
    }
  }

  for (let i = 0; i < arr.length; i++) {
    if (arr[i] != (i + 1)) return (i + 1);
  }

  return arr.length + 1;
}


console.log(findFirstMissingPositive([1,2,0,-2]));
console.log(findFirstMissingPositive([3,4,-1,1]));
console.log(findFirstMissingPositive([7,8,9,11,12]));
console.log(findFirstMissingPositive([-5]));
console.log(findFirstMissingPositive([-1, -2]));
console.log(findFirstMissingPositive([1]));
console.log(findFirstMissingPositive([-5, 1000]));
