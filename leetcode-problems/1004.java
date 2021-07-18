// https://leetcode.com/problems/max-consecutive-ones-iii/

class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums.length <= k) return nums.length;
        
        // sliding window
        int kUsed = 0;
        
        int low = 0;
        int high = 1;
        if (nums[low] == 0) kUsed++;
        if (nums[high] == 0) kUsed++;
        
        while(kUsed > k) {
            // move high up till under k threshold
            if (nums[high] == 0) kUsed--;
            high++;
            if (nums[low] == 0) kUsed--;
            low++;
        }
        
        int tempSum = nums[low] + nums[high];
        int max = tempSum + kUsed;
        
        while (high < nums.length - 1) {
            high++;
            tempSum += nums[high];
            if(nums[high] == 0) {
                kUsed++;
                while(kUsed > k) {
                    // move low up till under k threshold
                    tempSum -= nums[low];
                    if (nums[low] == 0) {
                        kUsed--;
                    }
                    low++;
                }
            }
            max = Math.max(max, tempSum + kUsed);
        }
        
        return max;
    }
}
