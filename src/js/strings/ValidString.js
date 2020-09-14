/**
 * A string to be valid if all characters of the string appear the same number of times. It is also valid if you can remove just
 * character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if
 * it is valid. If so, return YES, otherwise return NO.
 *
 * e.g.
 * Input: aabbcd
 * Output: No
 *
 * Input: aabbccddeefghi
 * Output: No
 *
 * Input: abcdefghhgfedecba
 * Output: Yes
 */


function isValid(s) {
  const map = {};

  for (let i = 0; i < s.length; i++) {
    const char = s.charAt(i);
    if (map[char]) map[char]++;
    else map[char] = 1;
  }

  let misMatchCount = 0, currFreq = 0;
  for (const char in map) {
    if (map.hasOwnProperty(char)) {
      if (currFreq === 0) currFreq = map[char];
      else if (currFreq === map[char]) continue;
      else misMatchCount++;
    }
  }

  return misMatchCount > 1 ? "NO" : "YES";
}

console.log(isValid("aabbcd"));
console.log(isValid("aabbccddeefghi"));
console.log(isValid("abcdefghhgfedecba"));
console.log(isValid("aaaabbcc"));
console.log(isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));

