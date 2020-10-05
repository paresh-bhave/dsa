/**
 * Problem: Convert byte array to String
 */

function bytesToString(byteArr) {
  let result = '';

  for (let i = 0; i < byteArr.length; i++) {
    result += String.fromCharCode(parseInt(byteArr[i], 2));
  }

  return result;
}

/**
 * String to bytes
 */
function decimalToBinary(decimal) {
  let binary = '';
  for (let i = 0; i < 8; i++) {
    binary = (decimal % 2) + binary;
    decimal = Math.floor(decimal/2);
  }
  return binary;
}

function stringToBytes(str) {
  const byteArr = [];

  for (var i = 0; i < str.length; i++) {
    let charCode = str.charCodeAt(i);
    if (charCode < 128) {
      byteArr[i] = decimalToBinary(charCode);
    } else {
      let char = s.charAt(i);
      console.log(char + ' is NOT an ASCII character');
      byteArr[i] = -1;
    }
  }
  return byteArr;
}

console.log(bytesToString(["01100110", "01101111", "01101111"]));

const testString = stringToBytes("Hello world");
console.log(bytesToString(testString));
