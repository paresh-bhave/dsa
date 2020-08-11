package com.ds.hash;

public class HashMap {
  public int key;
  public Object value;
  public HashMap next;
  
  public HashMap(int k, Object v) {
    key = k;
    value = v;
    next = null;
  }
  
  public HashMap() {
    next = null;
  }
  
  public int getKey() {
    return key;
  }
  
  public Object getValue() {
    return value;
  }
}
