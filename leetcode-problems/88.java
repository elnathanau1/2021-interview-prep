// https://leetcode.com/problems/merge-sorted-array/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nextIdx = nums1.length - 1;
        while (nextIdx >= 0) {
            int num1 = (m < 1) ? Integer.MIN_VALUE : nums1[m-1];
            int num2 = (n < 1) ? Integer.MIN_VALUE : nums2[n-1];
            if (num1 >= num2) {
                nums1[nextIdx] = num1;
                m--;
            }
            else {
                nums1[nextIdx] = num2;
                n--;
            }
            nextIdx--;
        }
    }
}
