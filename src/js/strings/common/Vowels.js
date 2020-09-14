//
// Problem: Count no of vowels and consonants in a string
//

/**
* function prints no. of vowels and consonants
*/
function countVowelsAndConsonants(str) {
  let vowels = 0;
  let consonants = 0;

  for (var i = 0; i < str.length; i++) {
    if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
      vowels++;
    } else if (str[i] != ''){
      consonants++;
    }
  }

  console.log("No. of vowels: ", vowels);
  console.log("No. of consonants: ", consonants);
}

countVowelsAndConsonants("abcdefghijklomnpqrstuvwxyz wdfqwd qwdqwd poi  pqowip  q");
