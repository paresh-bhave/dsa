// Problem: Check if string is a palindrome

/**
 * Using utility functions
 */

function isPalindromeUtil(str) {
  const newStr = str;
  return newStr.split('').reverse().join('') == str;
}

/**
 * Using general loop and index
 */

function isPalindrome(str) {
  let start = 0, end = str.length - 1;

  while(start <= end) {
    if(str.charAt(start) != str.charAt(end)) {
      return false;
    }
    start++;
    end--;
  }
  return true;
}

console.log(isPalindrome("abccba"));
console.log(isPalindrome("rtyrtyrtrtrty"));
console.log(isPalindrome("yrtrtyrtyrt"));
console.log(isPalindrome("qweqwrrwqrrewtertyrtu"));
console.log(isPalindrome("rtyrtyrtyrtyrtyrt"));
