/**
 * A string is said to be a special string if either of two conditions is met:
 * A- ll of the characters are the same, e.g. aaa.
 * - All characters except the middle one are the same, e.g. aadaa.
 *
 * A special substring is any substring of a string which meets one of those criteria.
 * Given a string, determine how many special substrings can be formed from it.
 *
 * e.g. Input = asasd
 * Output: 7
 * Possible special substr set = {a, s, a, s, d, asa, sas}
 */

 /**
  * Brute force approach
  */
function substrCount(n, s) {
  const isValidSubstr = (str) => {
    let start = 0,
        end = str.length - 1,
        mainChar = str.charAt(0);

    while (start < end) {
      if (
        str.charAt(start) !== str.charAt(end) ||
        str.charAt(start) !== mainChar ||
        str.charAt(end) !== mainChar
      ) return false;
      start++;
      end--;
    }
    return true;
  }

  let count = s.length;
  for (let i = 0; i < s.length; i++) {
    for (let j = i + 2; j < s.length + 1; j++) {
      let subStr = s.slice(i, j);
      if (isValidSubstr(subStr)) count++;
    }
  }
  return count;
}

/**
 * Efficient approach
 */
function subStrCount(n, s) {
  let count = s.length;

  for (let i = 0; i < s.length; i++) {
    const startChar = s.charAt(i);
    let diffCharIdx = -1

    for (let j = i + 1; j < s.length; j++) {
      const currChar = s.charAt(j);
      if (startChar === currChar) {
        if (diffCharIdx === -1 || (j - diffCharIdx) === (diffCharIdx - i)) count++;
      } else {
        if (diffCharIdx === -1) diffCharIdx = j;
        else break;
      }
    }
  }
  return count;
}

console.log(substrCount(8, "mnonopoo"));
console.log(subStrCount(5, "asasd"));
console.log(subStrCount(7, "abcbaba"));
console.log(subStrCount(4, "aaaa"));
