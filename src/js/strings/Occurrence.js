
/**
* Problem1: Count no. of occurrences of a given character
*/

function countCharacter(str, char) {
  let charCount = 0;

  for (let i = 0; i < str.length; i++) {
    if (str[i] == char) {
      charCount++;
    }
  }
  return charCount;
}

console.log("-- GIVEN CHAR COUNT --");
console.log(countCharacter("lorem ipsum dolor sit amet", "m"));
