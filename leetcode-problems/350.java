// 

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // brute force
        List<Integer> result = new ArrayList();
        List<Integer> list2 = new ArrayList();
        for (int i : nums2) {
            list2.add(i);
        }
        
        for (int i : nums1) {
            if (list2.contains(i)) {
                result.add(i);
                list2.remove(list2.indexOf(i));
            }
        }
        
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
        
    }
}

// HashMap Solution
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // map of occurances of each num from num1
        Map<Integer, Integer> occur = new HashMap();
        for (int i : nums1) {
            if (occur.containsKey(i)) {
                occur.put(i, occur.get(i) + 1);
            }
            else {
                occur.put(i, 1);
            }
        }
        
        List<Integer> intersection = new ArrayList();
        for(int i : nums2) {
            if (occur.containsKey(i) && occur.get(i) > 0) {
                occur.put(i, occur.get(i) - 1);
                intersection.add(i);
            }
        }
        
        return intersection.stream().mapToInt(x -> x).toArray();
        
    }
}
