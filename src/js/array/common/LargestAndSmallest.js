/**
 * Problem: Find the largest and smallest number in an unsorted integer array
 */

/**
 * Approach 1:
 *
 * - maintain to pointers smallest and largest
 * - iterate over array
 *  - if current number is greater than largest, assign it to largest
 *  - if current number is smaller than smallest, assign it to smallest
 */

function findLargestAndSmallest(arr) {
  let smallest = arr[0],
      largest = arr[0];

  for (let i = 1; i < arr.length; i++) {
    if (arr[i] > largest) largest = arr[i];
    else if (arr[i] < smallest) smallest = arr[i];
  }

  console.log(`Smallest: ${smallest} | Largest: ${largest}`);
}

findLargestAndSmallest([5,7,910,1,25,99,1002,998,650]);
findLargestAndSmallest([-20, 34, 21, -87, 92, 2147483647]);
