/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *   Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 *   Output: [[1,6],[8,10],[15,18]]
 *   Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *   Example 2:
 *
 *   Input: intervals = [[1,4],[4,5]]
 *   Output: [[1,5]]
 *   Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *   NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * Source: https://leetcode.com/problems/merge-intervals/
 */


/**
 * An efficient approach is to first sort the intervals according to the starting time. Once we have the sorted intervals, we can combine all intervals in a linear traversal. The idea is, in sorted array of intervals, if interval[i] doesn’t overlap with interval[i-1], then interval[i+1] cannot overlap with interval[i-1] because starting time of interval[i+1] must be greater than or equal to interval[i]. Following is the detailed step by step algorithm.
 *
 *
 * Algorith:
 * 1. Sort the intervals based on increasing order of starting time.
 * 2. Push the first interval on to a stack.
 * 3. For each interval do the following
 *   a. If the current interval does not overlap with the stack top, push it.
 *   b. If the current interval overlaps with stack top and ending
 *     time of current interval is more than that of stack top,
 *     update stack top with the ending  time of current interval.
 * 4. At the end stack contains the merged intervals.
 *
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 *
 * Source: https://www.geeksforgeeks.org/merging-intervals/,
 *         https://leetcode.com/problems/merge-intervals/
 */

/**
 * intervals [][]
 * [][]
 */
function mergeIntervals(intervals) {
  if (intervals.length <= 0) return [];

  // create an empty stack of intervals
  const stack = [];

  // sort the intervals in increasing order of start time
  intervals.sort((a, b) => a[0] - b[0]);

  // push the first element to the stack
  stack.push(intervals[0]);

  // start from next interval and merge if necessary
  for (let i = 1; i < intervals.length; i++) {

    // get interval from stack top
    let top = stack[stack.length - 1];

    // if current interval is not overlapping with stack top,
    // push it to the stack
    if (top[1] < intervals[i][0]) {
      stack.push(intervals[i]);
    }

    // Otherwise update the ending time of top if ending of current
    // interval is more
    else if (top[1] < intervals[i][1]) {
      top[1] = intervals[i][1];
      stack.pop();
      stack.push(top);
    }
  }

  let results = [];
  stack.forEach((element) => {
    results.push([element[0], element[1]]);
  });

  return results;
}

console.log(mergeOverlappingIntervals([[1,3],[8,10],[2,6],[15,18]]));
console.log(mergeOverlappingIntervals([[1,4],[4,5]]));
