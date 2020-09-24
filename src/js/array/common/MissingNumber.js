/**
 * How do you find the missing number in a given integer array of 1 to 100?
 */

 /**
  * Finds single missing number
  */
function findMissingNumber(arr) {
  const totalCount = arr.length + 1;
  const expectedSum = totalCount * ((totalCount + 1) / 2);
  let actualSum = 0;

  for (let i = 0; i < arr.length; i++) {
    actualSum += arr[i];
  }

  return expectedSum - actualSum;
}

console.log(findMissingNumber([1,2,3,4,6]));
console.log(findMissingNumber([1,2,3,4,5,6,8,9,10,11,12]));


/**
 * Find multiple missing numbers
 */
function findMultipleMissingNumber(arr) {
  const missingNumbers = [];
  const helper = {};

  /**
   * No need of this step if arrays is sorted
   * Just pick the last index;
   */
  let largest = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] > largest) largest = arr[i];
  }

  for(let i = 0; i < arr.length; i++) {
    helper[arr[i]] = 1;
  }

  for(let i = 1; i <= largest; i++) {
    if (!helper[i]) missingNumbers.push(i);
  }

  return missingNumbers;
}


console.log(findMultipleMissingNumber([1,2,3,4,8,10]));
console.log(findMultipleMissingNumber([1,2,3,4,5,6,8,9,10,12,15]));
