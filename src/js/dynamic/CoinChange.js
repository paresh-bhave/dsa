/**
 * https://leetcode.com/problems/coin-change/
 */

function coinChange(coins, amount) {
  if (coins.length === 0) return -1;

  if (amount === 0) return 0;

  let result = new Array(amount+1).fill(0);

  let count = (currAmount) => {
    /* Base cases */
    if (currAmount < 0) return -1;
    if (currAmount === 0) return 0;
    if (result[currAmount] !== 0) return result[currAmount];

    let minCoins = 987654321;

    for (let i = 0; i < coins.length; i++) {
      let newAmount = currAmount - coins[i];
      let value = count(newAmount);
      if (value !== -1 && value < minCoins) minCoins = value + 1;
    }

    /* If no coins found to make the amount, mark it -1*/
    result[currAmount] = (minCoins === 987654321) ? -1 : minCoins;
    return result[currAmount];
  }

  return count(amount);
}

console.log(coinChange([1,2,5], 11));
