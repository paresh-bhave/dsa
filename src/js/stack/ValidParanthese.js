/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example:
 * Input: "(()"
 * Output: 2
 */
function longestValidParentheses(str) {
  if (!str.length || typeof str != 'string') return 0;

  const stack = [-1];
  let count = 0;

  for (let i = 0; i < str.length; i++) {
    let char = str.charAt(i);

    if (char == '(') {
      stack.push(i);
    } else {
      stack.pop();
      if (stack.length > 0) {
        count = Math.max(count, i - stack[stack.length-1]);
      } else {
        stack.push(i);
      }
    }
  }
  // console.log(count);
  return count;
}

// console.log(longestValidParentheses("()"));
// console.log(longestValidParentheses("()[]{}"));
// console.log(longestValidParentheses("(]"));
// console.log(longestValidParentheses("(]"));


/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([)]"
 * Output: false
 *
 * Example 5:
 * Input: s = "{[]}"
 * Output: true
 *
 * Source: https://leetcode.com/problems/valid-parentheses/
 */

/**
 * Approach 1: Using map
 */
function longestValidParentheses(str) {
  if (!str.length || typeof str != 'string') return false;

  const stack = [];
  const map = {
    ')': '(',
    '}': '{',
    ']': '['
  };

  for (let i = 0; i < str.length; i++) {
    let char = str.charAt(i);

    if (map[char]) {
      let top = !stack.length ? '#' : stack.pop();
      if (top !== map[char]) return false;
    } else {
      stack.push(char);
    }
  }

  return stack.length === 0;
}

console.log(longestValidParentheses("()"));
console.log(longestValidParentheses("()[]{}"));
console.log(longestValidParentheses("(]"));
console.log(longestValidParentheses("{[]}"));


/**
 * Approach 1: Without map
 */
function longestValidParenthesesSwitch(str) {
  if (!str.length || typeof str != 'string') return false;

  const stack = [];

  for (let i = 0; i < str.length; i++) {
    let char = str.charAt(i);


    if (char === '(' || char === '[' || char === '{') {
      stack.push(char);
    } else {
      let top = !stack.length ? '#' : stack[stack.length-1];
      if (
        (top === '{' && char === '}') ||
        (top === '[' && char === ']') ||
        (top === '(' && char === ')')
      ) stack.pop();
      else return false;
    }
  }
  return stack.length <= 0;
}
console.log(longestValidParenthesesSwitch("()"));
console.log(longestValidParenthesesSwitch("()[]{}"));
console.log(longestValidParenthesesSwitch("(]"));
console.log(longestValidParenthesesSwitch("{[]}"));
console.log(longestValidParenthesesSwitch("]"));
console.log(longestValidParenthesesSwitch("("));


