/**
 * Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of
 * bribes necessary, or Too chaotic if the line configuration is not possible.
 *
 * Input: 2 1 5 3 4
 * Output: 3
 *
 * Input: 2 5 1 3
 * Output: Too chaotic
 */

function minimumBribe(q) {
  let bribes = 0;

  for (let i = q.length - 1; i >= 0; i--) {
    if (q[i] - (i + 1) > 2) {
      console.log("Too chaotic");
      return;
    }
    for (let j = Math.max(0, q[i] - 2); j < i; j++)
      if (q[j] > q[i]) bribes++;
  }
  console.log(bribes);
}


minimumBribe([2, 1, 5, 3, 4]);
minimumBribe([2, 5, 1, 3, 4]);
