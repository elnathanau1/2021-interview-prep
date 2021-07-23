// https://leetcode.com/problems/reverse-integer/

class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        
        int temp = x;
        int result = 0;
        while (temp != 0){
            int digitToAdd = Math.abs(temp % 10);
            if (result > (Integer.MAX_VALUE - digitToAdd) / 10) return 0;
            result = result * 10 + digitToAdd;
            temp = temp / 10;
        }
        
        return result * (x / Math.abs(x));
    }
}
