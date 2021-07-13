// https://leetcode.com/problems/design-hashmap/

import java.util.*;

class Pair {
    int key;
    int value;
    
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    LinkedList<Pair> list;
    public Bucket() {
        list = new LinkedList();
    }
    
    public int findKey(int key) {
        for (Pair pair : list) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }
    
    public void add(int key, int value) {
        boolean found = false;
        for (Pair pair : list) {
            if (pair.key == key) {
                pair.value = value;
                found = true;
            }
            break;
        }
        if (!found) list.add(new Pair(key, value));
    }
    
    public void remove(int key) {
        for (Pair pair : list) {
            if (pair.key == key){
                list.remove(pair);
                break;
            }
        }
    }
}

class MyHashMap {
    
    ArrayList<Bucket> buckets;
    private final int HASHTABLE_SIZE = 100000;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new ArrayList(HASHTABLE_SIZE);
        for (int i = 0; i < HASHTABLE_SIZE; i++) {
            buckets.add(new Bucket());
        }
    
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);
        buckets.get(hash).add(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        Bucket bucket = buckets.get(hash);
        return bucket.findKey(key);        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        buckets.get(hash).remove(key);
    }
    
    private int hash(int key) { 
        return key % HASHTABLE_SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
