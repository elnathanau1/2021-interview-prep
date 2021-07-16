// https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> match = new HashMap<>();
        
        match.put(')', '(');
        match.put('}', '{');
        match.put(']', '[');
        
        Stack<Character> stack = new Stack();
        
        for (char c : s.toCharArray()) {
            if (!match.containsKey(c)) stack.add(c); // is not a ending char
            else if (stack.isEmpty()) return false; // end when no need
            else if (match.get(c) == stack.peek()) stack.pop();
            else return false;
        }
        
        return stack.isEmpty();
    }
}
