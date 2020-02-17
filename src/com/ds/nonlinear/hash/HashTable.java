package com.ds.nonlinear.hash;

public class HashTable<T> {
  HashMap[] arrayMap;
  int size;
  
  public HashTable(int s) {
    size = s;
    arrayMap = new HashMap[size];
    for (int i = 0; i < size; i++) {
      arrayMap[i] = new HashMap();
    }
  }
  
  public int getHash(int key) {
    return key % size;
  }
  
  public void put(int key, Object value) {
    int index = getHash(key);
    HashMap mapObject = arrayMap[index];
    HashMap newItem= new HashMap(key, value);
    newItem.next = mapObject.next;
    mapObject.next=newItem;
  }
  
  public T get(int key) {
    T value = null;
    int index = getHash(key);
    HashMap mapObject = arrayMap[index];
    while (mapObject != null) {
      if (mapObject.getKey() == key) {
        value = (T) mapObject.getValue();
        break;
      }
      mapObject = mapObject.next;
    }
    return value;
  }
}
