/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 * Tag: #Google
 */

function romanToInt(str) {
  const map = { 'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000};
  let num = 0;

  for(let i = 0; i < str.length; i++) {
    const curr = map[str.charAt(i)],
          next = map[str.charAt(i+1)];

    if(curr < next) num -= curr;
    else num += curr;
  }
  return num;
}

/**
 * https://leetcode.com/problems/integer-to-roman/
 *
 * Tag: #Google
 */
function IntToRoman(num) {
  const map = { 1 : 'I',  4 : 'IV', 5 : 'V', 9 : 'IX', 10 : 'X', 40 : 'XL', 50 : 'L',  90 : 'XC', 100 : 'C', 400 : 'CD', 500 : 'D', 900 : 'CM', 1000 : 'M'}

  const keys = Object.keys(map).reverse().map(Number);

  let result = ''

  for(let n of keys) {
    const reps = Math.floor(num / n);
    result += map[n].repeat(reps);
    num = num % n;
  }
  return result;
}
