/**
 * Complete the makeAnagram function in the editor below. It must return an integer representing the minimum total characters
 * that must be deleted to make the strings anagrams.
 *
 * Input:
 * cde
 * abc
 *
 * Output: 4
 */

function makeAnagram(a, b) {
  const map = {};
  let count = 0;

  for (let i = 0; i < a.length; i++) {
    const char = a.charAt(i);
    if (map[char]) map[char]++;
    else map[char] = 1;
  }

  for (let i = 0; i < b.length; i++) {
    const char = b.charAt(i);
    if (map[char]) {
      if (map[char] == 1) delete map[char];
      else map[char] -= 1;
    }
    else count++;
  }

  for (const char in map)
    if (map.hasOwnProperty(char)) count += map[char];

  return count;
}

console.log(makeAnagram("abc", "cde"));
console.log(makeAnagram("abcd", "cdefe"));
console.log(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
