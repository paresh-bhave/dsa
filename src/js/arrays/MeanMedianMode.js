/**
 * Problem: Find mean, median and mode of sorted integer array
 */

 /**
  * The mean is the "avrage"
  *
  * - sum up all numbers and divide it by length
  */
function findMean(arr) {
  /**
   * Using ES6
   *
   * return (...arr) => arr.reduce((a, v) => a + v, 0) / arr.length
   */
  let sum = 0;
  for (let i = 0; i < arr.length; i++) sum += arr[i];
  return sum / arr.length;
}

/**
 * The median is the "middle" value in the list
 *
 * - if length is even return avrage of 2 middle numbers
 * - else return middle number
 */
function findMedian(arr) {
  arr.sort((a,b) => a - b);

  const length = arr.length;
  if (length % 2 === 0)
    return (arr[length / 2 - 1] + arr[length / 2]) / 2
  else
    return arr[length - 1  / 2];
}

/**
 * The mode is the number that repeats the most. As a result can be bimodal or multi-modal, the returned result is an array
 *
 * - create a map store the occurences of numbers
 * - create result array that stores the maximum occured numbers
 * - create a variable that stores max count
 * - first iteration stores the occurences in the map
 *  - if map has value, increase it by 1
 *  - else add key and assign 1 to it
 *  - if map[index] value is greater than max count, assign it to max count
 * - in second iteration, iterate over map, check value if value equals to max count, push it to results array
 * - return result
 */

function findMode(arr) {
  const map = {},
        results = [];

  let maxCount = 0;

  for (let i = 0; i < arr.length; i++) {
    let number = arr[i];
    if (!map[number]) map[number] = 1;
    else map[number]++;
    if (map[number] > maxCount) maxCount = map[number];
  }

  for (const key in map) {
    if (map.hasOwnProperty(key) && map[key] === maxCount) results.push(parseInt(key));
  }

  return results;
}

/**
 * The range of a list of numbers is the difference between the largest and smallest values
 *
 * - sort the numbers
 * - return arr of 0th indexed value and length - 1 indexed value
 */
function findRange(arr) {
  arr.sort((a, b) => a - b);
  return [arr[0], arr[arr.length - 1]];
}

console.log("--FIND MEAN, MEDIAN, MODE 7 RANGE FOR [3, 5, 4, 4, 1, 1, 2, 3]--");
const test = [3, 5, 4, 4, 1, 1, 2, 3];
console.log("Mean: ", findMean(test));
console.log("Median: ", findMedian(test));
console.log("Mode: ", findMode(test));
console.log("Range: ", findRange(test));
