// Problem: Reverse a given string

/**
 * Normal string reverse
 * Without utility functions like str.reverse()
 */
function reverse(str) {
  let newStr = "";
  let end = str.length - 1;

  while(end >= 0) {
    newStr += str.charAt(end);
    end--;
  }

  return newStr;
}

console.log("-- REVERSE --");
console.log(reverse("john doe"));
console.log(reverse("lorem ipsum dolor sit amet"));
console.log(reverse("a b c d e f g h i j k l m n o p q r s t u v w x y z"));

/**
 * String Reverse in Place
 * Without utility functions
 */

function reverseInPlace(str) {
  const charArr = [];

  /**
   * arr.split() part
   */
  for (let i = 0; i < str.length; i++) {
    charArr[i] = str.charAt(i);
  }

  /**
   * arr.reverse() part
   */
  let start = 0, end = charArr.length - 1;

  while(start < end) {
    let temp = charArr[start];
    charArr[start] = charArr[end];
    charArr[end] = temp;

    start++;
    end--;
  }

  /**
   * arr.join() part
   */
  let newStr = '';
  for (let i = 0; i < str.length; i++) {
    newStr += charArr[i];
  }
  return newStr;
}

console.log("\n-- IN PLACE REVERSE --");
console.log(reverseInPlace("john doe"));
console.log(reverseInPlace("lorem ipsum dolor sit amet"));
console.log(reverseInPlace("a b c d e f g h i j k l m n o p q r s t u v w x y z"));

/**
 * Using recursion
 */
function reverseRec(str) {
  return str ? reverseRec(str.substr(1)) + str[0] : str;
};

console.log("\n-- REVERSE USING RECURSION--");
console.log(reverseRec("john doe"));
console.log(reverseRec("lorem ipsum dolor sit amet"));
console.log(reverseRec("a b c d e f g h i j k l m n o p q r s t u v w x y z"));
