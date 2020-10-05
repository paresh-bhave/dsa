/**
 * Given an array of integers A of size N. A represents a histogram i.e A[i] denotes height of
 * the ith histogram’s bar. Width of each bar is 1.
 *
 * Example:
 * Input: [2,1,5,6,2,3]
 * Output: 10
 *
 * Source: https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
 *         https://leetcode.com/problems/largest-rectangle-in-histogram/
 */


/**
 * Approach:
 *
 * 1) Create an empty stack.
 *
 * 2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
 * ……a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
 * ……b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the
 * stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest
 * bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (
 * current index).
 *
 * 3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b
 * for every removed bar.
 *
 * Time Complexity: O(n)
 */

function largestHistogram(heights) {
  const stack = [-1];

  let maxArea = 0, i = 0, top, areaTop;

  while (i < heights.length) {
    if (!stack.length || heights[stack[stack.length-1]] <= heights[i]) {
      stack.push(i++);
    } else {
      top = stack[stack.length-1];
      stack.pop();

      areaTop = heights[top] * (!stack.length ? i : (i - stack[stack.length-1] - 1));
      if (maxArea < areaTop) maxArea = areaTop;
    }
  }

  while(stack.length > 0) {
    top = stack[stack.length-1];
    stack.pop();

    areaTop = heights[top] * (!stack.length ? i : (i - stack[stack.length-1] - 1));
    if (maxArea < areaTop) maxArea = areaTop;
  }

  return maxArea;
}

console.log("Result => ", largestHistogram([2,1,5,6,2,3]) );
console.log("Result => ", largestHistogram([1]) );
