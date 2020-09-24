package com.ds.array.practice;

import java.util.*;

public class LeftRotation {

  static void leftRotate(int arr[], int k) {
    int n = arr.length;
    int mod = k % n;

    for(int i = 0; i < n; ++i) {
      System.out.println("Mod => " + mod + " | iMod => " + (i + mod) % n);
      System.out.print(arr[(i + mod) % n] + " ");
    }

  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] nd = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nd[0]);

    int d = Integer.parseInt(nd[1]);

    int[] a = new int[n];

    String[] aItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int aItem = Integer.parseInt(aItems[i]);
      a[i] = aItem;
    }

    scanner.close();

    leftRotate(a, d);
  }
}

