// https://leetcode.com/problems/is-subsequence/

class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        int index = 0;
        for (char c : t.toCharArray()) {
            if (index >= s.length()) return true;
            if (c == sChars[index]) index++;
        }
        
        return index >= s.length();
    }
}
