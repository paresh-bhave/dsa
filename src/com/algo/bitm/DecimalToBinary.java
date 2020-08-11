package com.algo.bitm;

/**
 * Given a (decimal - e g 3 72) number that is passed in as a string, print the binary representation
 * If the number can not be represented accurately in binary, print “ERROR”
 *
 * Solution:
 * First, let’s start off by asking ourselves what a non-integer number in binary looks like By analogy to a decimal number,
 * the number n = 0.101 = 1 * (1/2^1) + 0 * (1/2^2) + 1 * (1/2^3)
 *
 * Printing the int part of n is straight-forward (see below) To print the decimal part, we can multiply by 2 and check if the 2*n is greater than
 * or equal to one This is essentially “shifting” the fractional sum That is:
 * r = 2*n = 2*0.101 = 1*(1 / 2^0) + 0*(1 / 2^1) + 1*(1 / 2^2) = 1.01
 *
 * If r >= 1, then we know that n had a 1 right after the decimal point By doing this continuously, we can check every digit
 */

public class DecimalToBinary {
  static String printBinary(String num) {
    int intPart = Integer.parseInt(num.substring(0, num.indexOf('.')));
    double decPart = Integer.parseInt(num.substring(num.indexOf('.') + 1));
    
    String intStr = "";
  
    while (intPart > 0) {
      int rightShift = intPart % 2;
      intPart >>= 1;
      intStr = rightShift + intStr;
    }
    
    StringBuffer decStr = new StringBuffer();
    
    while (decPart > 0) {
      if (decStr.length() > 32) return "ERROR";
      
      if (decPart == 1) {
        decStr.append((int) decPart);
        break;
      }
      
      double right = decPart * 2;
      
      if (right >= 1) {
        decStr.append(1);
        decPart = right - 1;
      } else {
        decStr.append(0);
        decPart = right;
      }
    }
    
    return intStr + decStr.toString();
  }
  
  public static void main(String[] args) {
    System.out.println(printBinary("3.72"));
    System.out.println(printBinary("5.128"));
  }
}
