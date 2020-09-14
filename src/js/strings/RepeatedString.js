/**
 * Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in
 * the prefix of length n in the infinitely repeating string.
 *
 * Input:
 * aba
 * 10
 *
 * Output:
 * 7
 */


function repeatedString(s, n) {
  let count = 0;
  let k = s.length;
  let p = Math.floor(n / k);

  for(let i = 0; i < s.length; i++) {
    if (s.charAt(i) === 'a') count++;
  }

  count *= p;

  for(let i = 0; i < n % s.length; i++) {
    if (s.charAt(i) === 'a') count++;
  }

  return Math.floor(count);
}

console.log(repeatedString("epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq", 549382313570));
console.log(repeatedString("aba", 10));
console.log(repeatedString("a", 10000000000));

