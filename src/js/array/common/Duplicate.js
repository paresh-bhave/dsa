/**
 * Problem 1: Find the duplicate number on a given integer array
 **/

/**
 * Approach 1: Grouping duplicates
 * - sort the array to group the duplicates in ascending order
 * - maintain another array to store results
 * - iterate over array
 * - compare it with previous index
 *   - if number matches, store it in results array
 * - return results
 *
 * Complexity: O(log n) given we use efficient sorting algorithm
 **/

function findDuplicatesbySorting(arr) {
  const results = [];

  arr.sort((a, b) => a - b);

  for (let i = 1; i < arr.length; ++i) {
    if (arr[i] === arr[i - 1]) results.push(arr[i]);
  }

  return results;
}

// console.log("--USING SORTING--");
// console.log(findDuplicatesbySorting([78,99,100,100,20,23,25,25,22,22,1,1,1,7,7,8,8,23,39,39,53,53,65,66,61,61,39]));

/**
 * Approach 2: Using set
 * - create a new set
 * - iterate over array
 *  - if number does not exists in the set, add it to set
 * - return set
 *
 * Complexity: O(n) because we're looping only once but requires with additional n space
 **/

function findDuplicatesUsingSet(arr) {
  const set = new Set();
  const results = [];

  for (let i = 0; i < arr.length; i++) {
    if (set.has(arr[i])) results.push(arr[i]);
    else set.add(arr[i]);
  }

  return results;
}

console.log("--USING SET--");
console.log(findDuplicatesUsingSet([78,99,100,100,20,23,25,25,22,22,1,1,1,7,7,8,8,23,39,39,53,53,65,66,61,61,39]));

/**
 * Problem 2: Remove duplicates from given array and return array which contains unique numbers
 *
 * Can use the set approach
 */
function removeDuplicates(arr) {
  const set = new Set();

  for (let i = 0; i < arr.length; i++) {
    if (!set.has(arr[i])) set.add(arr[i]);
  }

  return set;
}
console.log("--REMOVE DUPLICATES--");
console.log(removeDuplicates([78,99,100,100,20,23,25,25,23,22,22,1,1,1,7,7,8,8,23,,39,39,39,53,53,65,66,61,61,39]));
