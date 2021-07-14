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
