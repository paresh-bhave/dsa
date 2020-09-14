/**
 * Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum number of
 * deletions to make the alternating string.
 *
 * e.g.
 * Input: AAABBB
 * Output: 4
 */


function alternatingCharacters(s) {
  let count = 0;

  const A = "A", B = "B";

  for(let i = 0; i < s.length; i++) {
    const currChar = s.charAt(i);
    const nextChar = s.charAt(i+1);

    if ((currChar === A && nextChar === A) || (currChar === B && nextChar === B)) {
      count++;
    }
  }

  return count;
}

console.log( alternatingCharacters("AAAA") );
console.log( alternatingCharacters("BBBBB") );
console.log( alternatingCharacters("ABABABAB") );
console.log( alternatingCharacters("BABABA") );
console.log( alternatingCharacters("AAABBB") );
