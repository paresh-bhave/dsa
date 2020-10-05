/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise). You need to do this in place.
 *
 * Example:
 *
 * Input:
 * [
 *   [1, 2],
 *   [3, 4]
 * ]
 *
 * Output:
 * [
 *   [3, 1],
 *   [4, 2]
 * ]
 *
 * Source: https://www.interviewbit.com/problems/rotate-matrix/
 */

/**
 * Appraoch:
 * A 4 X 4 matrix will have 2 cycles. The first cycle is formed by its 1st row, last column, last row and 1st column. The second cycle is formed by 2nd row, second-last column, second-last row and 2nd column. The idea is for each square cycle, swap the elements involved with the corresponding cell in the matrix in anti-clockwise direction i.e. from top to left, left to bottom, bottom to right and from right to top one at a time using nothing but a temporary variable to achieve this.
 *
 * - There is N/2 squares or cycles in a matrix of side N. Process a square one at a time. Run a loop to traverse the matrix a cycle at a time, i.e loop from 0 to N/2 – 1, loop counter is i
 * - Consider elements in group of 4 in current square, rotate the 4 elements at a time. So the number of such groups in a cycle is N – 2*i.
 * - So run a loop in each cycle from x to N – x – 1, loop counter is y
 * - The elements in the current group is (x, y), (y, N-1-x), (N-1-x, N-1-y), (N-1-y, x), now rotate the these 4 elements, i.e (x, y) <- (y, N-1-x), (y, N-1-x)<- (N-1-x, N-1-y), (N-1-x, N-1-y)<- (N-1-y, x), (N-1-y, x)<- (x, y)
 *
 * Source: https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 *
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 */

// ant-clockwise
function rotateMatrixAntiClockWise(matrix) {
  let n = matrix.length;

  // consider all squares one by one
  for (let i = 0; i < n / 2; i++) {

    // consider elements in a group of 4 in current square
    for (let j = i; j < n - i - 1; j++) {

      //store current cell in a temp variable
      let temp = matrix[i][j];

      // move values from right to top
      matrix[i][j] = matrix[j][n - 1 - i];

       // move values from bottom to right
      matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j];

      // move values from left to bottom
      matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i];

      // assign temp to left
      matrix[n - 1 - j][i] = temp;
    }
  }

  return matrix;
}

// clockwise
function rotateMatrixClockWise(matrix) {
  let n = matrix.length;

  // consider all squares one by one
  for (let i = 0; i < n / 2; i++) {

    // consider elements in a group of 4 in current square
    for (let j = i; j < n - i - 1; j++) {

      //store current cell in a temp variable
      let temp = matrix[i][j];

      // move values from right to top
      matrix[i][j] = matrix[n - 1 - j][i];

      // move values from bottom to right
      matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];


      // move values from left to bottom
      matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];

      // assign temp to left
      matrix[j][n - 1 - i] = temp;
    }
  }

  return matrix;
}

function print(matrix) {
  const n = matrix.length;

  for (let i = 0; i < n; i++) {
    let row = '';
    for (let j = 0; j < n; j++) {
      row += `${matrix[i][j]} `;
    }
    console.log(row);
  }
}

// tests
const m11 = [
  [1, 2],
  [3, 4],
];
const r1 = rotateMatrixAntiClockWise(m11);
console.log("-- M1 ANTI-CLOCKWISE --");
print(r1);

const m12 = [
  [1, 2],
  [3, 4],
];
const r2 = rotateMatrixClockWise(m12);
console.log("\n-- M1 CLOCKWISE --");
print(r2);

const m21 = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
];
const r3 = rotateMatrixAntiClockWise(m21);
console.log("\n-- M2 ANTI-CLOCKWISE --");
print(r3);

const m22 = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
];
const r4 = rotateMatrixClockWise(m22);
console.log("\n-- M2 CLOCKWISE --");
print(r4);


