// https://leetcode.com/problems/count-sorted-vowel-strings/

class Solution {
    public int countVowelStrings(int n) {
        if (n == 1) return 5;
        
        // each index corresponds to starting with that char {a,e,i,o,u}
        int[] prev = new int[]{1,1,1,1,1};
        int sum = 5;
        
        for (int count = 2; count <= n; count++) {
            int newSum = 0;
            int[] curr = new int[prev.length];
            for (int i = 0; i < curr.length; i++) {
                int newVal = sum;
                curr[i] = newVal;
                newSum += newVal;
                sum -= prev[i];
            }
            sum = newSum;
            prev = curr;
        }
        
        return sum;
        
    }
}
