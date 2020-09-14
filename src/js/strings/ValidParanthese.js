//
// Problem: Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
// Input: "(()"
// Output: 2
//

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
  return count;
}

console.log(longestValidParentheses("(()"));
console.log(longestValidParentheses(")()())"));
console.log(longestValidParentheses("()(())"));
console.log(longestValidParentheses("()(()"));
