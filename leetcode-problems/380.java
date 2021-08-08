// https://leetcode.com/problems/insert-delete-getrandom-o1/

class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    int size;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            if (list.size() == size) {
                map.put(val, list.size());
                list.add(val);
            }
            else {
                map.put(val, size);
                list.set(size, val);
            }
            size++;
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int replaceVal = list.get(size-1);
            list.set(map.get(val), replaceVal);
            map.put(replaceVal, map.get(val));
            map.remove(val);
            size--;
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = (int) (Math.random() * size);
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
