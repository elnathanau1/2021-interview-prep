// https://leetcode.com/problems/maximum-product-subarray/

class Solution {
    public int maxProduct(int[] nums) {
        int[] minSoFar = new int[nums.length];
        int[] maxSoFar = new int[nums.length];
        
        minSoFar[0] = nums[0];
        maxSoFar[0] = nums[0];
        int max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            minSoFar[i] = Math.min(Math.min(num, minSoFar[i-1] * num), maxSoFar[i-1] * num);
            maxSoFar[i] = Math.max(Math.max(num, minSoFar[i-1] * num), maxSoFar[i-1] * num);
            
            max = Math.max(max, maxSoFar[i]);
        }
        
        return max;
    }
}
