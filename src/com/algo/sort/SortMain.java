package com.algo.sort;

import java.util.Arrays;
import java.util.Random;

public class SortMain {
  
  static class Stopwatch {
    long time;
    
    public void start() {
      this.time = System.nanoTime();
    }
    
    public double getTime() {
      return (System.nanoTime() - time) / 1_000_000_000.0;
    }
  }
  
  
  public static void main(String[] args) {
    int arr[] = new int[1000];
  
    Random random = new Random();
    for (int i = 0; i < 1000; i++) {
      arr[i] = random.nextInt(10000);
    }
  
    Stopwatch stopwatch = new Stopwatch();
    stopwatch.start();
    
    /**
     * Bubble sort
     */
    int[] a0 = Arrays.copyOf(arr, arr.length);
    Bubble.sort(a0, false);
    System.out.println("BUBBLE SORTED ARRAY --> " + Arrays.toString(a0));
    System.out.println("BUBBLE SORTING TIME --> " + stopwatch.getTime() + "s");
    
    /**
     * Selection sort
     */
    stopwatch.start();
    int[] a1 = Arrays.copyOf(arr, arr.length);
    Selection.sort(a1);
    System.out.println("\nSELECTION SORTED ARRAY --> " + Arrays.toString(a1));
    System.out.println("SELECTION SORTING TIME --> " + stopwatch.getTime() + "s");
  
    /**
     * Insertion sort
     */
    stopwatch.start();
    int[] a2 = Arrays.copyOf(arr, arr.length);
    Insertion.sort(a2);
    System.out.println("\nINSERTION SORTED ARRAY --> " + Arrays.toString(a2));
    System.out.println("INSERTION SORTING TIME --> " + stopwatch.getTime() + "s");
  
    /**
     * Shell sort
     */
    stopwatch.start();
    int[] a3 = Arrays.copyOf(arr, arr.length);
    Shell.sort(a3);
    System.out.println("\nSHELL SORTED ARRAY --> " + Arrays.toString(a3));
    System.out.println("SHELL SORTING TIME --> " + stopwatch.getTime() + "s");
  
    /**
     * heap sort
     */
    stopwatch.start();
    int[] a4 = Arrays.copyOf(arr, arr.length);
    Heap.sort(a4);
    System.out.println("\nHEAP SORTED ARRAY --> " + Arrays.toString(a4));
    System.out.println("HEAP SORTING TIME --> " + stopwatch.getTime() + "s");
  
    /**
     * Radix sort
     */
    stopwatch.start();
    int[] a5 = Arrays.copyOf(arr, arr.length);
    Radix.sort(a5);
    System.out.println("\nRADIX SORTED ARRAY --> " + Arrays.toString(a5));
    System.out.println("RADIX SORTING TIME --> " + stopwatch.getTime() + "s");
  
    /**
     * Merge sort
     */
    stopwatch.start();
    int[] a6 = Arrays.copyOf(arr, arr.length);
    Merge.sort(a6, 0, a6.length - 1);
    System.out.println("\nMERGE SORTED ARRAY --> " + Arrays.toString(a6));
    System.out.println("MERGE SORTING TIME --> " + stopwatch.getTime() + "s");
  
    /**
     * Quick sort
     */
    stopwatch.start();
    int[] a7 = Arrays.copyOf(arr, arr.length);
    Quick.sort(a7, 0, a7.length - 1);
    System.out.println("\nQUICK SORTED ARRAY --> " + Arrays.toString(a7));
    System.out.println("QUICK SORTING TIME --> " + stopwatch.getTime() + "s");
  }
}
