/**
 * Given a 2D array of distinct integers with n numbers,
 * "compress" the array such that the resulting array's numbers are in the range [1, n] and
 * their relative order is kept.
 *
 * Relative order means that if a number at position (row1, col1) is smaller than a number at position
 * (row2, col2) in the original array, it should still have that relationship in the resulting array.
 * Example 1:
 * Input:
 * 7 6
 * 4 9
 *
 * Output:
 * 3 2
 * 1 4
 *
 *
 * Approach:
 *
 * - Flatten the whole array matrix
 * - Sort the array, assume we get arr[i], i=0,n-1
 * - Build the reverse map of arr[i]->i+1
 * - Traverse the matrix and replace the value using the reversed map.
 *
 * For the follow-up question, since the relative order is only in each row or column,
 * we really don't need to sort the whole array. The whole matrix (size r x c)can be considered as a
 * DAG graph of vertices in which direct edge is drawn from the smaller to the next bigger vertex in the s
 * same row or column,
 *
 * In each row, if we sort all the numbers, we can establish c-1 edges. Similarly, in each column, we can
 * establish r-1 edges. Once we build DAG done, we realize that any position doesn't have incoming edge
 * can be assigned with the smallest integer(at the beginning, current_value is 1).
 *
 * We could put all the pairs(total incoming edge, vertex index) to an array and process by batch.
 * Each time we get all the items with total incoming edge = 0, assign them with current_value,
 * then decrease 1 for all the vertices connected to it. These vertices will be the candidate for the next
 * batch. At the end of each process, increment current_value by 1.
 *
 * Time complexity: O(r * c * (log(r)+log(c) +1 ) )
 *
 * Source: https://leetcode.com/discuss/interview-question/326564/google-onsite-interview-compress-2d-array
 */


function compress2DArray(matrix) {

  let priority = {};

  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[i].length; j++) {
      priority[matrix[i][j]] = [i, j];
    }
  }

  let rowMax = new Array(matrix.length).fill(0),
      colMax = new Array(matrix[0].length).fill(0);
      currColMax = 0,
      currRowMax = 0;

  for(let key in priority) {
    if (priority.hasOwnProperty(key)) {
      let i = priority[key][0],
          j = priority[key][1];

      currRowMax = rowMax[i];
      currColMax = colMax[j];

      let valToSet = Math.max(currRowMax, currColMax) + 1;

      rowMax[i] = valToSet;
      colMax[j] = valToSet;

      matrix[i][j] = valToSet;
    }
  }

  console.log(matrix);
}

// tests

compress2DArray([
  [7, 6],
  [4, 9]
]);

compress2DArray([
  [25, 74, 54],
  [12, 56, 83]
]);
