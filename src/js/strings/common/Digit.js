// Problem: Find number of digits in a string

/**
 * Using Regex and Utility function
 */
function checkDigitsLenRegex(str) {
  return str.replace(/^[0-9]/,"").length;
}
console.log("-- USING REGEX --");
console.log(checkDigitsLenRegex("akahjvd23874t23qhvabefkjh3287t"));
console.log(checkDigitsLenRegex("jsdhvbk23769837r9387r0r98ycwertr3967t376rt"));


/**
 * without regex
 */
function checkDigitsLen(str) {
  let digitCount = 0;

  for (let i = 0; i < str.length; i++) {
    if (Number(str.charAt(i)) != NaN) {
      digitCount++;
    }
  }
  return digitCount;
}
console.log("\n-- WITHOUT REGEX --");
console.log(checkDigitsLen("akahjvd23874t23qhvabefkjh3287t"));
console.log(checkDigitsLen("jsdhvbk23769837r9387r0r98ycwertr3967t376rt"));
