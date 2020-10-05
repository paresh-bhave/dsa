// Problem: Check if 2 strings are anagram
/**
 * Use simple insertion sort for character array (if not using utils arr.sort)
 */
function sortStr(str) {
  let charArr = [];

  /**
   * similar to str.split('')
   */
  for (let m = 0; m < str.length; m++) {
    charArr[m] = str.charAt(m);
  }

  /**
   * Similar to arr.sort but using simple bubble sort
   */
  for (let i = 0; i < charArr.length; i++) {
    for (let j = i + 1; j < charArr.length; j++) {
      if (charArr[i] > charArr[j]) {
        let temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
      }
    }
  }

  /**
   * arr.join function
   */
  let newStr = '';
  for (let k = 0; k < charArr.length; k++) {
    newStr += charArr[k];
  }

  return newStr;
}

function isAnagram(str1, str2) {
  if (str1 == null || str2 == null) return false;
  return sortStr(str1) == sortStr(str2);
}

console.log("-- WITHOUT UTIL FUNCTION --");
console.log(isAnagram("fired", "fried"));
console.log(isAnagram("a gentleman", "elegant man"));
console.log(isAnagram("a gentleman", "elegant man"));
console.log(isAnagram("eleven plus two", "twelve plus one"));
console.log(isAnagram("random thoughts", "chaotic mind"));


/**
 * Using JS util functions
 */

function sortStrUtil(str) {
  return str.split('').sort().join('');
}
function isAnagramUtil(str1, str2) {
  if (str1 == null || str2 == null) return false;
  return sortStrUtil(str1) == sortStrUtil(str2);
}

console.log("\n-- USING UTIL FUNCTIONS --");
console.log(isAnagramUtil("fired", "fried"));
console.log(isAnagramUtil("a gentleman", "elegant man"));
console.log(isAnagramUtil("a gentleman", "elegant man"));
console.log(isAnagramUtil("eleven plus two", "twelve plus one"));
console.log(isAnagramUtil("random thoughts", "chaotic mind"));
