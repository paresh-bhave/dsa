/**
 * Union Find DS -- Quick Find Approach
 */

package com.ds.unionfind;

public class UFQuickFind {
  private int[] id;
  
  UFQuickFind(int n) {
    id = new int[n];
  
    /**
     * Set ID of each object to itself (n array accesses)
     */
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }
  
  public boolean connected(int p, int q) {
    return id[p] == this.id[q];
  }
  
  public void union(int p, int q) {
    int pid = id[p];
    int qid = id[q];
  
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid) id[i] = qid;
    }
  }
}
