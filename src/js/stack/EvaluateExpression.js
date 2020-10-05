
/**
 * Dijkstra's two stack algortihm
 */
function evaluate(str) {
  const charArr = str.split('');

  const operators = [],
        operands = [];

  for (let i = 0; i < charArr.length; i++) {
    const char = charArr[i];

    if (char === "(") {
      continue;
    } else if (char === "+" || char === "*" || char === "-" || char === "/") {
      operators.push(char);
    } else if (char === ")") {

      let num1 = operands.pop(),
          num2 = operands.pop();
          operator = operators.pop();

      switch (operator) {
        case "*": operands.push(num1 * num2); break;
        case "/": operands.push(num1 / num2); break;
        case "+": operands.push(num1 + num2); break;
        case "-": operands.push(num1 - num2); break;
      }
    } else if (!isNaN(Number(char))) {
      operands.push(Number(char));
    }
  }

  return operands.pop();
}
// console.log( evaluate("(1+((2+3)*(4*5)))") );


/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Source: https://www.interviewbit.com/problems/evaluate-expression/
 *         https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
function evaluateReversePolish(charArr) {
  const operands = [];

  for (let i = 0; i < charArr.length; i++) {
    const char = charArr[i];

    if (!isNaN(parseInt(char))) {
      operands.push(parseInt(char));
    } else if (char == '+' || char == '*' || char == '-' || char == '/') {
      const num1 = operands.pop(),
            num2 = operands.pop();

      switch (char) {
        case '*': operands.push(num1 * num2); break;
        case '/': operands.push(Math.trunc(num2 / num1)); break;
        case '+': operands.push(num1 + num2); break;
        case '-': operands.push(num2 - num1); break;
      }
    }
  }

  return operands.pop();
}

console.log( evaluateReversePolish(["2", "1", "+", "3", "*"]) );
console.log( evaluateReversePolish(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]) );
console.log( evaluateReversePolish(["4","13","5","/","+"]) );
