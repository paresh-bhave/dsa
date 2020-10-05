/**
 * Problem: Find all permutations of a given string
 */

function permutation(perm, str) {
  if (str == '') {
    console.log(perm);
    return perm;
  } else {
    for (let i = 0; i < str.length; i++) {
      permutation(`${perm}${str.charAt(i)}`, `${str.substr(0, i)}${str.substr(i+1, str.length-1)}`);
    }
  }
}

// permutation("", "bands");
permutation("", "asasd");
