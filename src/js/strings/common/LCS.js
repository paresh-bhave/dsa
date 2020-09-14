/**
 * Longest Common Subsequence Problem:
 *
 * Finding the longest subsequence common to all sequences in a set of sequences (often just two sequences)
 */


function findLongestCommonSequence(str1, str2) {
  const arr = [];

  for (let i = 0; i <= str1.length; i++) {
    arr[i] = [];
    for (let j = 0; j <= str2.length; j++) {
      arr[i][j] = 0;
    }
  }

  for (let i = 1; i <= str1.length; i++) {
    for (let j = 1; j <= str2.length; j++) {
      if (str1.charAt(i - 1) === str2.charAt(j - 1)) {
        arr[i][j] = arr[i-1][j-1] + 1;
      } else {
        arr[i][j] = Math.max(arr[i][j-1], arr[i-1][j]);
      }
    }
  }

  return arr[str1.length][str2.length];
}

console.log(findLongestCommonSequence("HARRY", "SALLY"));
console.log(findLongestCommonSequence("AA", "BB"));
console.log(findLongestCommonSequence("ABCDEF", "FBDAMN"));
console.log(findLongestCommonSequence("SHINCHAN", "NOHARAAA"));
