// Problem: Find first non-repeating character from string

/**
* Idea 1: Maintain two set, 1 that collects repeating character and second non repeating character
*/

function findFirstNonRepeatingChar1(str) {
  const charArr = str.split('');

  const repeating = [];
  const nonRepeating = [];

  for (let i = 0; i < charArr.length; i++) {
    if (repeating.indexOf(charArr[i]) > -1) {
      continue;
    }
    if (nonRepeating.indexOf(charArr[i]) > -1) {
      const index = nonRepeating.indexOf(charArr[i]);
      nonRepeating.splice(index, 1);
      repeating.push(charArr[i]);
    } else {
      nonRepeating.push(charArr[i]);
    }
  }

  return nonRepeating[0];
}

console.log("-- USING TWO STACK --");
console.log(findFirstNonRepeatingChar1('abcdedcba'));
console.log(findFirstNonRepeatingChar1('lorem ipsum dolor sit amet'));


/**
* Idea 2: Maintain a map with character counts
*/
function findFirstNonRepeatingChar2(str) {
  const charArr = str.split('');
  const charMap = {};

  for (let i = 0; i < charArr.length; i++) {
    if (charMap[charArr[i]]) {
      charMap[charArr[i]]++;
    } else {
      charMap[charArr[i]] = 1;
    }
  }

  for (let char in charMap) {
    if (charMap.hasOwnProperty(char) && charMap[char] == 1) {
      return charMap[char];
    }
  }
  return null;
}

console.log("-- USING MAP --");
console.log(findFirstNonRepeatingChar1('abcdedcba'));
console.log(findFirstNonRepeatingChar1('lorem ipsum dolor sit amet'));
