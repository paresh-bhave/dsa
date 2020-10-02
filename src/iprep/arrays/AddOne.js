/**
 * Given a non-negative number represented as an array of digits,
 * add 1 to the number ( increment the number represented by the digits ).
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Input: If the vector has [1, 2, 3]
 * the returned vector should be [1, 2, 4]
 */

/**
 * Approach 1: using string
 */
function addOne(digits) {
  if (digits.length === 1 && digits[0] === 0) return [1];

  if (digits[0] === 0) digits.shift();

  let lastIndex = digits.length-1;
  let i = 0;
  let next;

  if (digits[lastIndex] < 9) {
    digits[lastIndex] = digits[lastIndex] + 1;
    return digits;
  }

  if (digits.length === 1 && digits[lastIndex] === 9) {
    return [1,0];
  }

  while (i < lastIndex) {
    if (digits[lastIndex-i] >= 9) {
      if (next < 9 && i > 0) {
        break;
      }

      next = digits[lastIndex-(i+1)];
      digits[lastIndex-(i+1)] = digits[lastIndex-(i+1)] + 1;
      digits.splice(lastIndex-i, 1, 0);
    } else if (digits[lastIndex-i] < 9) {
      break;
    } else {
      digits[lastIndex-i] = digits[lastIndex-i] + 1;
      break;
    }
    i++;
  }

  if (digits[0] == 10) {
    digits.splice(0, 1, 1, 0);
  }

  return digits;
}

// console.log( addOne([0,1,2,3]) );
// console.log( addOne([9,9,9,9]) );
console.log( addOne([6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3]) );
console.log( addOne([0, 3, 7, 6, 4, 0, 5, 5, 5]) );
