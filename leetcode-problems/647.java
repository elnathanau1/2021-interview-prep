// https://leetcode.com/problems/palindromic-substrings/

class Solution {
    public int countSubstrings(String s) {
        char [] arr = s.toCharArray();
        int count = 0;
        int low = 0;
        int high = 0;
        while (low <= arr.length - 1) {
            count += numPalindromes(arr, low, high);
            // center on low
            if (low == high) {   
                high++;
            }
            // center between indices
            else {
                low++;
            }
        }
        
        return count;
    }
    
    private int numPalindromes(char[] arr, int low, int high) {
        int maxPossible = Math.min(low, arr.length - high - 1);
        
        int count = 0;
        for(int i = 0; i <= maxPossible; i++) {
            if (arr[low-i] == arr[high+i]) count++;
            else break;
        }
        
        return count;
    }
}
