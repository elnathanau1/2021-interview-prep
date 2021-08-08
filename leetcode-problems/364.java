// https://leetcode.com/problems/nested-list-weight-sum-ii/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> flatList = new ArrayList<>();
        List<Integer> depths = new ArrayList<>();
        
        flattenList(nestedList, flatList, depths, 1);
        int max = 0;
        for (int i : depths) max = Math.max(max, i);
        for (int i = 0; i < depths.size(); i++) depths.set(i, max - depths.get(i) + 1);
        
        int sum = 0;
        for (int i = 0; i < flatList.size(); i++) sum += flatList.get(i) * depths.get(i);
        
        return sum;
        
    }
    
    private void flattenList(List<NestedInteger> nestedList, List<Integer> flatList, List<Integer> depths, int depth) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                flatList.add(ni.getInteger());
                depths.add(depth);
            }
            else flattenList(ni.getList(), flatList, depths, depth+1);
        }
    }
}
