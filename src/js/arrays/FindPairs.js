/**
 * Problem: Find all pairs of an integer array whose sum is equal to a given number?
 */

function print(a, b) {
  console.log(`(${a}, ${b})`);
}

/**
 * Approach 1: Brute Force
 * For each number, iterate over the array and check if it sums to given number
 * Complexity: O(n^2) !!problematic
 */
function findPairsBF(arr, sum) {
  for (let i = 0; i < arr.length; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      if (arr[i] + arr[j] === sum) print(arr[i], arr[j]);
    }
  }
}

console.log("--BRUTE FORCE APPROACH--");
findPairsBF([2, 4, 3, 5, 6, -2, 4, 7, 8, 9], 7);


/**
 * Approach 2: Using Map/Set
 *
 * - store all numbers in an object/set
 * - check if it contains second value in pair
 *
 * Complexity: O(n) but additional auxilallry space
 */
function findPairsUsingSet(arr, sum) {
  const set = new Set();

  for (let i = 0; i < arr.length; i++) {
    const target = sum - arr[i];
    if (set.has(target)) print(arr[i], target);
    else set.add(arr[i]);
  }
}
console.log("--USING SET--");
findPairsUsingSet([0, 14, 0, 4, 7, 8, 3, 5, 7], 11);


/**
 * Approach 3: In place using 2 pointers
 * - sort the numbers (possibly using efficient sorts like merge)
 * - maintain 2 pointers left = 0 and right = len - 1
 * - iterate until left < right
 *  - if arr[left] + arr[right] == sum
 *    - print the numbers
 *    - increase left and right
 *  - if sum < arr[left] + arr[right], increase left
 *  - if sum > arr[left] + arr[right], decrease right
 *
 * Complexity: O(n Log n) given we're using efficient sorting method
 */

function findPairsUsingPointers(arr, sum) {
  if (arr.length < 2) return;

  arr.sort((a, b) => a - b);

  let left = 0,
      right = arr.length - 1;

  while (left < right) {
    let currSum = arr[left] + arr[right];

    if (currSum === sum) {
      print(arr[left], arr[right]);
      left++;
      right--;
    } else if (currSum < sum) {
      left++;
    } else {
      right--;
    }
  }
}
console.log("--USING TWO POINTERS--");
findPairsUsingSet([2, 4, 7, 5, 9, 10, -1], 9);
