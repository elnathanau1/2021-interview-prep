// https://leetcode.com/problems/generate-parentheses/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resultSet = new ArrayList<>();
        addToList("", 0, 0, resultSet, n);
        return resultSet;
    }
    
    public void addToList(String current, int openUsed, int closedUsed, List<String> resultSet, int n) {
        if (openUsed == n && closedUsed == n) {
            resultSet.add(current);
            return;
        }
        if (closedUsed < openUsed) addToList(current + ')', openUsed, closedUsed + 1, resultSet, n);
        if (openUsed < n) addToList(current + '(', openUsed + 1, closedUsed, resultSet, n);
    }
}
