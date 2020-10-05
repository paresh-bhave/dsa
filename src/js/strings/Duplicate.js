// Problem: Find duplicates from given string
// Proble2: Remove duplicates from given string

/**
 * Returns array of duplicate characters
 */

function findDuplicate(str) {
  const charCount = {};

  for (let i = 0; i < str.length; i++) {
    let char = str.charAt(i); // add toLowerCase if case sensitivity does not matter
    if (char != ' ' && charCount[char]) {
      charCount[char]++;
    } else {
      charCount[char] = 1;
    }
  }

  const dups = [];

  for (const key in charCount) {
    if (charCount.hasOwnProperty(key) && charCount[key] >= 2) {
      dups.push(key)
    }
  }

  return dups;
}

console.log("-- FIND DUPLICATE --");
console.log(findDuplicate("aSDadaDASFWEWERWGSDVCXVXGDFGadasas"));
console.log(findDuplicate("lorem ipsum dolor sit amet"));


/**
 * Remove duplicate from strings
 */
function removeDuplicate(str) {
  const charCount = {};
  let noDuplicatestr = '';

  for (let i = 0; i < str.length; i++) {
    let char = str.charAt(i); // add toLowerCase if case sensitivity does not matter
    if (char == ' ' || charCount[char]) {
      continue;
    } else {
      charCount[char] = 1;
      noDuplicatestr += char;
    }
  }

  return noDuplicatestr;
}

console.log("\n-- REMOVE DUPLICATE --");
console.log(removeDuplicate("aSDadaDASFWEWERWGSDVCXVXGDFGadasas"));
console.log(removeDuplicate("lorem ipsum dolor sit amet"));
