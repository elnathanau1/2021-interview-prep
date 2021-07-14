// https://leetcode.com/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        loop:
        for (int i = 0; i < nums.length; i++) {
            int[] possibleArr = new int[nums.length - i];
            possibleArr[0] = nums[i];
            
            if(nums[i] > max) max = nums[i];
            
            for (int j = i + 1; j < nums.length; j++) {
                int newSum = possibleArr[j - i -1] + nums[j];
                if (newSum > max) max = newSum;
                if (newSum > 0) {
                    possibleArr[j - i] = newSum;
                }
                else {
                    continue loop;
                }
            }
        }
        
        return max;
    }
}
