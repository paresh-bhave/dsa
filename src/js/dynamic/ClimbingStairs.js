/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 */

function climbingStairs(n) {
  let count = (remaining, result) => {
    if (remaining < 0) return 0;
    if (remaining === 0) return 1;

    if (result[remaining]) return result[remaining];

    result[remaining] = count(remaining - 1, result) + count(remaining - 2, result);
    return result[remaining];
  }

  return count(n, {});
}
