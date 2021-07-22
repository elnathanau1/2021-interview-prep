// https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        char[] sArr = s.toCharArray();
        int maxLength = Integer.MIN_VALUE;
        int low = 0;
        int high = 0;
        for(int i = 0; i < sArr.length; i++) {
            // check if pal center is at i
            int lowI = i - 1;
            int highI = i + 1;
            while (lowI >= 0 && highI <= sArr.length - 1 && sArr[lowI] == sArr[highI]) {
                if (highI - lowI + 1 > maxLength) {
                    maxLength = highI - lowI + 1;
                    low = lowI;
                    high = highI;
                }
                lowI--;
                highI++;
            }
            
            // check pal center is middle
            lowI = i;
            highI = i + 1;
            while (lowI >= 0 && highI <= sArr.length - 1 && sArr[lowI] == sArr[highI]) {
                if (highI - lowI + 1 > maxLength) {
                    maxLength = highI - lowI + 1;
                    low = lowI;
                    high = highI;
                }
                lowI--;
                highI++;
            }
        }
        
        return s.substring(low, high+1);
    }
}
