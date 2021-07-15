// https://leetcode.com/problems/valid-perfect-square

class Solution {
    public boolean isPerfectSquare(int num) {
        int a = 0;
        int b = num/2;
        while (a != b) {
            int midpoint = (a + b) / 2;
            int tempSquare = midpoint * midpoint;
            if (tempSquare == num) return true;
            if (tempSquare > num) b = midpoint;
            else a = midpoint + 1;
        }
        
        if (a * a == num) return true;
        else return false;
    }
}
