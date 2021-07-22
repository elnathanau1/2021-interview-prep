// https://leetcode.com/problems/fibonacci-number/

class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        int follow = 0;
        int curr = 1;
        int index = 1;
        while (index < n) {
            index++;
            int temp = curr;
            curr = curr + follow;
            follow = temp;
        }
        return curr;
    }
}
