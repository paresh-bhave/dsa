/**
 *
 * You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that
 * is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 * You can return the answer in any order.
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 *
 */


function findSubstringIndices(str, words) {
  if (words.length === 0) return [0];
  if (str.length === 0) return [];

  let map = {},
      result = [],
      compare = '';

  words.sort();

  for (let i = 0; i < words.length; i++) {
    compare += words[i];
    if (map[words[i]]) {
      map[words[i]]++;
    } else {
      map[words[i]] = 1;
    }
  }

  let wordLen = words[0].length,
      totalLen = wordLen * words.length;

  for (let i = 0; i < str.length - totalLen + 1; i++) {
    let text = str.substr(i, wordLen);
    if (map[text]) {
      let temp = [];
      for (let j = i; j < (i + totalLen); j+= wordLen) {
        temp.push(str.substr(j, wordLen));
      }
      if (compare === temp.sort().join('')) result.push(i);
    }
  }

  return result;
}

console.log( findSubstringIndices("barfoothefoobarman", ["foo", "bar"]) );
console.log( findSubstringIndices("wordgoodgoodgoodbestword", ["word","good","best","word"]) );
console.log( findSubstringIndices("barfoofoobarthefoobarman", ["bar","foo","the"]) );
