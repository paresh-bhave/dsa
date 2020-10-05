/**
 * Starting with a 1-indexed array of zeros and a list of operations,
 * for each operation add a value to each of the array element between two given indices, inclusive.
 * Once all operations have been performed, return the maximum value in the array.
 *
 * n = 10
 * queries = [
 *  [1,5,3],
 *  [4,8,7],
 *  [6,9,1]
 * ]
 *
 * a b k
 * 1 5 3
 * 4 8 7
 * 6 9 1
 *
 * Add the values of k between the indices  and  inclusive:
 *
 * 1 2 3  4  5 6 7 8 9 10 -- > Index
 * [0,0,0, 0, 0,0,0,0,0, 0]
 * [3,3,3, 3, 3,0,0,0,0, 0]
 * [3,3,3,10,10,7,7,7,0, 0]
 * [3,3,3,10,10,8,8,8,1, 0]
 *
 * Output: 10
 */

function arrayManipulation(n, queries) {
  const arr = new Array(n + 1).fill(0);
  for (let i = 0; i < queries.length; i++) {
    let a = queries[i][0];
    let b = queries[i][1];
    let k = queries[i][2];

    arr[a-1] += k;
    arr[b] -= k;
  }

  let sum = 0;
  let max = 0;
  for (let i = 0; i < n; i++) {
      sum += arr[i];
      max = Math.max(max, sum);
  }

  return max;
}

const queries1 = [
  [1, 5, 3],
  [4, 8, 7],
  [6, 9, 1]
];
console.log(arrayManipulation(10, queries1));

const queries2 = [
  [1, 2, 100],
  [2, 5, 100],
  [3, 4, 100]
];
console.log(arrayManipulation(5, queries2));
