/**
 * Given an index k, return the kth row of the Pascal’s triangle.
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 *
 * Example: 3
 * Return : [1,3,3,1]
 *
 */

function kthRow(row) {
  let n = row + 1;
  let result = [];

  let c = 1;

  for (let i = 1; i <= n; i++) {
    result.push(c);
    c = c * (n - i) / i;
  }

  return result;
  // console.log(result);
}

// kthRow(3);

// Bonus implementation
//
/**
 *  In mathematics, Pascal's triangle is a triangular array of the binomial coefficients.
 *         1
 *       1   1
 *     1   2   1
 *   1  3     3  1 => 3rd Row
 *
 * .. so on
 */
function generatePascalsTriangle(n) {
  let result = [];
  for(let line = 1; line <= n; line++) {
    let col = 1;
    // let rowStr = '';
    result.push([]);
    for(let i = 1; i <= line; i++) {
        result[line-1].push(col);
        // rowStr += `${col} `;
        col = col * (line - i) / i;
    }
    // console.log(rowStr);
  }
  return result;
}


console.log(generatePascalsTriangle(4));
