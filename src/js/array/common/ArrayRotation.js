/**
 * Problem 1: Rotate array to the left by given count
 */

function rotateLeft(arr, by) {
  const result = [];

  for (let i = 0; i < arr.length; i++)
    result[i] = arr[((by % arr.length) + i) % arr.length];

  return result;
}

/**
 * Problem 2: Rotate array to the right by given count
 */
function rotateRight(arr, by) {
  const result = [];

  for (let i = 0; i < arr.length; i++)
    result[(i + by) % arr.length] = arr[i];

  return result;
}

console.log(rotateLeft([1,2,3,4,5,6,7,8], 5));
console.log(rotateRight([1,2,3,4,5,6,7,8], 5));
