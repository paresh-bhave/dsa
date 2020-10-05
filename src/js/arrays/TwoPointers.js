/**
 * Problem: Given a sorted array A (sorted in ascending order), having N integers, find if there exists any pair of elements
 * (A[i], A[j]) such that their sum is equal to X.
 *
 * Input: Arr = [10, 20, 35, 50, 75, 80], Sum = 70
 * Output: [20, 50]
 *
 * Input: Arr = [10, 20, 35, 50, 75, 80], Sum = 99
 * Output: []
 *
 * Approach: Two Pointers
 * Two pointers is really an easy and effective technique which is typically used for searching pairs in a sorted array.
 *
 * We take two pointers, one representing the first element and other representing the last element of the array,
 * and then we add the values kept at both the pointers. If their sum is smaller than X then we shift the left pointer to
 * right or if their sum is greater than X then we shift the right pointer to left, in order to get closer to the sum. We
 * keep moving the pointers until we get the sum as X.
 *
 * Complexity: O(n)
 *
 * Source: https://www.geeksforgeeks.org/two-pointers-technique/
 *
 * Tags: #Array #TwoPointers
 */

function findSmallestPair(arr, sum) {
  let left = 0,
      right = arr.length - 1;

  while (left < right) {
    if (arr[left] + arr[right] === sum) return [arr[left], arr[right]];
    else if (arr[left] + arr[right] < sum) left++;
    else right--;
  }

  return [];
}

console.log(findSmallestPair([10, 20, 35, 50, 75, 80], 70));
console.log(findSmallestPair([10, 20, 35, 50, 75, 80], 99));
console.log(findSmallestPair([10, 20, 35, 50, 75, 80], 55));
