package com.ds.unionfind;

public class UFQuickUnion {
  private int[] sz;
  private int[] id;
  
  public UFQuickUnion(int n) {
    id = new int[n];
    sz = new int[n];
  
    /**
     * Set ID of each object to itself (n array accesses)
     */
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }
  
  /**
   * Chase parent pointers until reach root
   * (Depth of i array accesses)
   */
  private int root(int i) {
    while (i != id[i]) {
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }
  
  /**
   * Check if p and q have same root
   * (Depth of p and q array accesses)
   */
  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }
  
  /**
   * Change root of p to point root of q
   * (Depth of p and q array accesses)
   */
  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    
    if (i == j) return;
    
    if (sz[i] < sz[j]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }
  }
}
