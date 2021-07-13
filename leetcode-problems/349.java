import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet();
        HashSet<Integer> set2 = new HashSet();
        
        // O(n)
        for (int i : nums1) { 
            set1.add(i);
        }
        
        // O(m)
        for (int j : nums2) {
            set2.add(j);
        }
        
        HashSet<Integer> resultSet = new HashSet();
        // O(n)
        for (int i : set1) {
            if (set2.contains(i)) {
                resultSet.add(i); 
            }
        }
        
        
        
        return resultSet.stream().mapToInt(i -> i).toArray();
    }
}
