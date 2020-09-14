/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */

 function minWindow(str, t) {
  if (typeof str !== 'string' ||
      typeof t !== 'string' ||
      str == '' ||
      t == '' ||
      str.length < t.length)
        return '';

  const hashPat = new Array(256).fill(0),
        hashStr = new Array(256).fill(0);

  for (let i = 0; i < t.length; i++) {
    const charCode = t.charCodeAt(i);
    hashPat[charCode]++;
  }

  let count = 0,
      start = 0,
      index = -1,
      min = 32767;

  for (let i = 0; i < str.length; i++) {
    const currChar = str.charCodeAt(i);

    hashStr[currChar]++;

    if (hashPat[currChar] !== 0 && hashStr[currChar] <= hashPat[currChar]) count++;

    if (count === t.length) {
      let startChar = str.charCodeAt(start);

      while(hashStr[startChar] > hashPat[startChar] || hashPat[startChar] === 0) {
        if (hashStr[startChar] > hashPat[startChar]) {
          hashStr[startChar]--;
        }
        start++;
        startChar = str.charCodeAt(start);
      }

      let windowLen = i - start + 1;

      if (min > windowLen) {
        min = windowLen;
        index = start;
      }
    }
  }

  if (index === -1) return '';

  return str.substr(index, min);
}


console.log(minWindow("this is a test string", "tist"));
console.log(minWindow("ADOBECODEBANC", "ABC"));
