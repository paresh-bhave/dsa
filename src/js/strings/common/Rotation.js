//
// Problem: Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
// (eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
//

function areRotations(str1, str2) {
  return (str1.length == str2.length) && ((str1+str1).indexOf(str2) > -1);
}

console.log(areRotations("AACD","ACDA"));
console.log(areRotations("IndiaVsEngland","EnglandIndiaVs"));
console.log(areRotations("right","left"));
