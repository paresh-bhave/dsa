package com.warmup;

import java.math.BigInteger;

/**
 * The factorial of the integer , written , is defined as:
 *
 * Calculate and print the factorial of a given integer.
 *
 * Note: Factorials of n > 20 can't be stored even in a  long long variable. Big integers must be used for such calculations. Languages like Java, Python, Ruby etc. can handle big integers, but we need to write additional code in C/C++ to handle huge values.
 *
 * We recommend solving this challenge using BigIntegers.
 */

public class ExtraLongFactorial {
  static void extraLongFactorials(int n) {
    BigInteger f = new BigInteger("1");
    for (int i = 2; i <= n; i++) {
      f = f.multiply(BigInteger.valueOf(i));
    }
    System.out.println(f);
  }
  
  public static void main(String[] args) {
    extraLongFactorials(25);
  }
}
