// https://leetcode.com/problems/counting-bits/

class Solution {
    public int[] countBits(int n) {
        int[] bitCount = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0) bitCount[i] = 0;
            else bitCount[i] = i % 2 + bitCount[i / 2];
        }
        
        return bitCount;
    }
}
