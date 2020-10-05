/**
 *You are given a series of video clips from a sporting event that lasted T seconds.  These video clips can be overlapping with each other and have varied lengths.

Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1].  We can cut these clips into segments freely: for example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].

Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event ([0, T]).  If the task is impossible, return -1.
 *
 * Example 1:
 *
 * Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10
 * Output: 3
 *
 * Explanation:
 * We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
 * Then, we can reconstruct the sporting event as follows:
 * We cut [1,9] into segments [1,2] + [2,8] + [8,9].
 * Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 10].
 *
 *
 * Source: https://leetcode.com/problems/video-stitching/
 *
 * Tag: #Google #RangeIntervals
 */


function videoStitching(clips, T) {
  clips.sort((a, b) => a[0] - b[0]);

  let sStart = 0;
      sEnd = 0;
      clipsCount = 0;
      index = 0;

  while (sStart < T) {

    /*find the longest video that starts before our sStart*/
    while (index < clips.length && clips[index][0] <= sStart) {
      sEnd = Math.max(sEnd, clips[index][1]);
      index++;
    }

    /* Made no advancement */
    if (sStart == sEnd) return -1;

    clipsCount++;
    sStart = sEnd;
  }

  return clipsCount;
}

videoStitching([[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], 10);
videoStitching([[0,1],[1,2]], 5);
videoStitching([[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]], 9);
videoStitching([[0,4],[2,8]], 5);
