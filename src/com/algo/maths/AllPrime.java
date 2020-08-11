package com.algo.maths;

public class AllPrime {
  
  static boolean isPrime(int n) {
      //check if n is a multiple of 2
      if (n % 2 == 0) return false;
      
      //if not, then just check the odds
      for(int i=3; i <= Math.sqrt(n); i+=2) {
        if(n % i==0) return false;
      }
      return true;
    }
  
  static void allPrimeBetween(int n, int m) {
    for (int i = n; i <= m; i++) {
      if (isPrime(i)) System.out.println(i);
    }
  }
  
  static void findPrime(int n) {
    // Print the number of 2s that divide n
    while (n % 2 == 0) {
      System.out.println(2 + " => ");
      n /= 2;
    }
  
    // n must be odd at this point.  So we can
    // skip one element (Note i = i +2)
  
    for (int i = 3; i <= Math.sqrt(n); i+= 2) {
      // While i divides n, print i and divide n
      while(n % i == 0) {
        System.out.print(i + " => ");
        n /= i;
      }
    }
    if (n > 2) System.out.print(n);
  }
  
  public static void main(String[] args) {
    findPrime(1150);
  
    allPrimeBetween(500, 3000);
  }
}
