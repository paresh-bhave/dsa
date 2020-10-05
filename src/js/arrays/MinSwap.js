/**
 * Complete the function minimumSwaps in the editor below. It must return an integer representing the minimum number of swaps
 * to sort the array.
 *
 * Input: 4 3 1 2
 * Output: 3
 */

function minSwap(arr) {
  let count = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] !== (i + 1)) {
      while(arr[i] !== (i + 1)) {
        let temp = arr[arr[i] - 1];
        arr[arr[i] - 1] = arr[i];
        arr[i] = temp;
        count++;
      }
    }
  }
  return count;
}

console.log(minSwap([1,3,5,2,4,6,7]));
console.log(minSwap([2,3,4,1,5]));
