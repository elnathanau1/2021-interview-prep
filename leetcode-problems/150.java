// https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        return helper(tokens, tokens.length - 1)[0];
    }
    
    private int[] helper(String[] tokens, int index) {
        String op = tokens[index];
        int bIndex = index - 2;
        int a;
        int b;
        
        if (isOp(tokens[index-1])) {
            int[] fA = helper(tokens, index - 1);
            a = fA[0];
            bIndex = fA[1] - 1;
        }
        else {
            a = Integer.parseInt(tokens[index - 1]);
        }
        
        if (isOp(tokens[bIndex])) {
            int[] fB = helper(tokens, bIndex);
            b = fB[0];
            bIndex = fB[1];
        }
        else {
            b = Integer.parseInt(tokens[bIndex]);
        }
        
        switch(op) {
            case "+": return new int[]{ a + b, bIndex };
            case "-": return new int[]{ b - a, bIndex };
            case "*": return new int[]{ a * b, bIndex };
            case "/": return new int[]{ b / a, bIndex };
            default: return new int[] { 0, 0 };
        }
    }
    
    private boolean isOp(String str) {
        switch(str) {
            case "+": return true;
            case "-": return true;
            case "*": return true;
            case "/": return true;
            default: return false;
        }
    }
    
}
