/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Input:
 * [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Source: https://leetcode.com/problems/spiral-matrix/
 */

function spiralOrder(matrix) {
  let result = [];
  let firstRow = 0,
      lastRow = matrix.length - 1,
      firstCol = 0,
      lastCol = matrix[0].length - 1;

  while (firstRow <= lastRow && firstCol <= lastCol) {

    for (let i = firstCol; i <= lastCol; i++) result.push(matrix[firstRow][i]);
    for (let i = firstRow + 1; i <= lastRow; i++) result.push(matrix[i][lastCol]);

    if (firstRow < lastRow && firstCol < lastCol) {
      for (let i = lastCol - 1; i > firstCol; i--) result.push(matrix[lastRow][i]);
      for (let i = lastRow; i > firstRow; i--) result.push(matrix[i][firstCol]);
    }

    firstRow++;
    lastRow--;
    firstCol++;
    lastCol--;
  }

  return result;
}

const matrix1 = [
  [ 1, 2, 3 ],
  [ 4, 5, 6 ],
  [ 7, 8, 9 ]
];

const matrix2 = [
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
];

console.log( spiralOrder(matrix1) );
console.log( spiralOrder(matrix2) );
