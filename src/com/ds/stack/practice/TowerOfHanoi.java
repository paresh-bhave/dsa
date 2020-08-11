package com.ds.stack.practice;

import java.util.Stack;

/**
 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes which can slide on to any tower
 * The puzzle starts with disks sorted in ascending order of size from top to bottom (e g , each disk sits on top of an even larger one)
 * You have the following constraints:
 * (A) Only one disk can be moved at a time
 * (B) A disk is slid off the top of one rod onto the next rod
 * (C) A disk can only be placed on top of a larger disk
 * <p>
 * We need to move N disks from Rod 1 to Rod 3, but let’s start from the beginning Moving the top disk is easy - we just move it to Disk 3
 * Can we move the top two disks? Yes:
 * 1 Move Disk 1 from Rod 1 to Rod 2
 * 2 Move Disk 2 from Rod 1 to Rod 3
 * 3 Move Disk 1 from Rod 2 to Rod 3
 * <p>
 * Can we move the top three disks?
 * 1 We know we can move the top two disks around from one Rod to another (as shown earlier), so let’s assume we have moved Disk 1 and 2 to Rod 2
 * 2 Move Disk 3 to Rod 3
 * 3 Again we know we can move the top two disks around, so let’s move them from Rod 2 to Rod 3
 * <p>
 * This approach leads to a natural recursive algorithm:
 */

public class TowerOfHanoi {
  private Stack<Integer> disks;
  
  private int index;
  
  public TowerOfHanoi(int index) {
    this.index = index;
    this.disks = new Stack<>();
  }
  
  public int index() {
    return index;
  }
  
  public void add(int d) {
    if (!disks.isEmpty() && disks.peek() <= d) {
      System.out.println("Error placing disk " + d);
    } else {
      disks.push(d);
    }
  }
  
  public void moveTopTo(TowerOfHanoi t) {
    int top = disks.pop();
    t.add(top);
    System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
  }
  
  public void print() {
    System.out.println("Contents of Tower " + index());
    for (int i = disks.size() - 1; i >= 0; i--) {
      System.out.println(" " + disks.get(i));
    }
  }
  
  public void moveDisks(int n, TowerOfHanoi destination, TowerOfHanoi buffer) {
    if (n > 0) {
      moveDisks(n - 1, buffer, destination);
      moveTopTo(destination);
      buffer.moveDisks(n - 1, destination, this);
    }
  }
  
  public static void main(String[] args) {
    int n = 5;
    TowerOfHanoi[] towers = new TowerOfHanoi[n];
    for (int i = 0; i < 3; i++) towers[i] = new TowerOfHanoi(i);
    for (int i = n - 1; i >= 0; i--) towers[0].add(i);
    towers[0].moveDisks(n, towers[2], towers[1]);
  }
}
