package com.practice.java.lld;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
 public static void main(String[] args) {
//   LRUCacheImpl lRUCache = new LRUCacheImpl(2);
//   lRUCache.put(1, 1); // cache is {1=1}
//   lRUCache.put(2, 2); // cache is {1=1, 2=2}
//   lRUCache.get(1);    // return 1
//   lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//   lRUCache.get(2);    // returns -1 (not found)
//   lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//   lRUCache.get(1);    // return -1 (not found)
//   lRUCache.get(3);    // return 3
//   lRUCache.get(4);
   
   
   
   LRUCacheImpl lRUCache = new LRUCacheImpl(2);
   lRUCache.get(2);
   lRUCache.put(2, 6);
   lRUCache.get(1);
   lRUCache.put(1, 5);
   lRUCache.put(1, 2);
   lRUCache.get(1);
   lRUCache.get(2);
}
}

class LRUCacheImpl {
  int capacity;
  Map<Integer, Integer> keyValueMap;
  Deque<Integer> priorityQueue;
  
  public LRUCacheImpl(int capacity) {
    this.capacity = capacity;
    this.keyValueMap = new HashMap<>();
    this.priorityQueue = new ArrayDeque<>();
  }
  
  public int get(int key) {
      if (priorityQueue.contains(key)) {
        priorityQueue.remove(key);
        priorityQueue.addFirst(key);
        return keyValueMap.get(key);
      } else {
        return -1;
      }
  }
  
  public void put(int key, int value) {
      if (!priorityQueue.contains(key)) {
        if (this.capacity == priorityQueue.size()) {
          int element = priorityQueue.removeLast();
          keyValueMap.remove(element);
        }
      } else {
        priorityQueue.remove(key);
      }
      keyValueMap.put(key, value);
      priorityQueue.addFirst(key);
      return;
  }
}
