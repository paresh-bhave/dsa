/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Example 3:
 * Input: intervals = [], newInterval = [5,7]
 * Output: [[5,7]]
 *
 * Example 4:
 * Input: intervals = [[1,5]], newInterval = [2,3]
 * Output: [[1,5]]
 *
 * Example 5:
 * Input: intervals = [[1,5]], newInterval = [2,7]
 * Output: [[1,7]]
 *
 * Make sure the returned intervals are also sorted.
 *
 * Constraints:
 * - 0 <= intervals.length <= 104
 * - intervals[i].length == 2
 * - 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * - intervals is sorted by intervals[i][0] in ascending order.
 * - newInterval.length == 2
 * - 0 <= newInterval[0] <= newInterval[1] <= 105
 *
 * Source: https://www.interviewbit.com/problems/merge-intervals/,
 *         https://leetcode.com/problems/insert-interval/
 */



/**
 * Approach: Let the new interval to be inserted is : [a, b]
 *
 * Case 1 : b < (starting time of first interval in set)
 * In this case simply insert new interval at the beginning of the set.
 *
 * Case 2 : (ending value of last interval in set) < a
 * In this case simply insert new interval at the end of the set.
 *
 * Case 3 : a ≤ (starting value of first interval) and b ≥ (ending value of last interval)
 * In this case the new interval overlaps with all the intervals, i.e., it contains all the intervals.
 * So the final answer is the new interval itself.
 *
 * Case 4 : The new interval does not overlap with any interval in the set and
 * falls between any two intervals in the set
 * In this case simply insert the interval in the correct position in the set.
 *
 * Case 5 : The new interval overlaps with the interval(s) of the set.
 * In this case simply merge the new interval with overlapping intervals
 *
 * Time Complexity : O(n)
 * Auxiliary Space : O(n)
 *
 * Source: https://www.geeksforgeeks.org/insert-in-sorted-and-non-overlapping-interval-array/
 */
function insertIntervals(intervals, newInterval) {

  intervals.push(newInterval);

  intervals.sort((a, b) => a[0] - b[0]);

  // A subroutine to check if intervals overlap or not.
  const doesOverlap = (a, b) => Math.min(a[1], b[1]) >= Math.max(a[0], b[0]);

  const result = [];
  const n = intervals.length;

  // If set is empty, push new interval and return the result
  if (n === 0) {
    result.push(newInterval);
    return result;
  }

  // Case 1 and 2, newIntervals to be inserted at corners
  if (newInterval[1] < intervals[0][0] || newInterval[0] > intervals[n - 1][1]) {
    if (newInterval[1] < intervals[0][0]) result.push(intervals[0]);

    for (let i = 0; i < n; i++) result.push(intervals[i]);

    if (newInterval[0] > intervals[n - 1][1]) result.push(newInterval);

    return result;
  }

  // Case 3 (New interval covers all existing)
  if (newInterval[0] <= intervals[0][0] && newInterval[1] >= intervals[n - 1][1]) {
    result.push(newInterval);
    return result;
  }


  // Case 4 and 5
  // These two cases need to check whether
  // intervals overlap or not. For this we
  // can use a subroutine that will perform
  // this function.
  let isOverlapped = true;
  for (let i = 0; i < n; i++) {
    isOverlapped = doesOverlap(intervals[i], newInterval);

    if (!isOverlapped) {
      result.push(intervals[i])

      // Case 4 To check if given interval lies b/w two intrvals
      if (i < n && newInterval[0] > intervals[i][1] && newInterval[1] < intervals[i + 1][0])
        result.push(newInterval);

      continue;
    }

    // Case 5: Mergin overlapping intervals
    // Starting time of new merged interval is minimum of starting time of both overlapping intervals
    const temp = [Math.min(newInterval[0], intervals[i][0])];

    // Traverse the set until intervals are overlapping
    while(i < n && isOverlapped) {

      // Ending time of new merged interval is maximum of ending time both overlapping intervals
      temp[1] = Math.max(newInterval[1], intervals[i][1]);

      if (i === n - 1) isOverlapped = false;
      else isOverlapped = doesOverlap(intervals[i + 1], newInterval);

      i++;
    }

    i--;
    result.push(temp);
  }

  return result;
}


console.log( insertIntervals([[1,3],[6,9]], [2, 5]) );
console.log( insertIntervals([[1,2],[3,5],[6,7],[8,10],[12,16]], [4,8]) );
console.log( insertIntervals([], [5,7]) );
console.log( insertIntervals([[1,5]], [2,3]) );
console.log( insertIntervals([[1,5]], [2,7]) );
console.log( insertIntervals([[1,5]], [0,0]) );

