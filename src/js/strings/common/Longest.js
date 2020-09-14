//
// Problem: Find longest substring without repeating characters
//
// Sliding window technique
//

function findLongestSubstrLength(str) {
  if (typeof str != 'string' || !str.length) return 0;
  if (str.length == 1) return 1;

  const charArr = str.split('');
  const charMap = new Map();

  let start = 0,
      longest = 0;

  for (let i = 0; i < charArr.length; i++) {
    if (!charMap.has(charArr[i])) {
      charMap.set(charArr[i], i);
    } else {
      i = charMap.get(charArr[i]);
      charMap.clear();
    }

    longest = longest < charMap.size ? charMap.size : longest;
  }
  return longest;
}

console.log("-- LONGEST UNIQUE SUBSTR --");
console.log(findLongestSubstrLength("abcabcbb"));
console.log(findLongestSubstrLength("geeksforgeeks"));
console.log(findLongestSubstrLength("bbbbb"));
console.log(findLongestSubstrLength("pwwkew"));


//
// Problem 2: Find longest palindromic substring characters
//
// Sliding window technique
//

function longestPalindrome(str){
  if(!str || str.length <= 1) {
    return str;
  }

  const expand = (s, begin, end) => {
    while(begin >= 0 && end <= s.length - 1 && s[begin] === s[end]) {
      begin--;
      end++;
    }
    return s.substring(begin + 1, end);
  }

  let longest = str.substring(0, 1);

  for(let i = 0; i < str.length; i++) {
    let temp = expand(str, i, i);

    if(temp.length > longest.length) {
      longest = temp;
    }

    temp = expand(str, i, i + 1);

    if(temp.length > longest.length) {
      longest = temp;
    }
  }
  return longest;
}
console.log("-- LONGEST PALINDROME SUBSTR --");
console.log(longestPalindrome("abcabcbb"));
console.log(longestPalindrome("geeksforgeeks"));
