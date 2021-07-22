// https://leetcode.com/problems/all-possible-full-binary-trees/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList();
        
        // map num nodes -> list of possible full binary trees
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        for (int count = 1; count <= n; count += 2){
            List<TreeNode> possible = new ArrayList<>();
            if (count == 1) possible.add(new TreeNode(0, null, null));
            else { // 3, 5, 7, ...
                for (int i = 1; i < count; i += 2) {
                    int j = count - i - 1; // get the pairs of trees that will make up this new tree
                    List<TreeNode> iList = map.get(i);
                    List<TreeNode> jList = map.get(j);
                    for (TreeNode iNode : iList) {
                        for (TreeNode jNode : jList) {
                            possible.add(new TreeNode(0, iNode, jNode));
                        }
                    }
                }
            }
            map.put(count, possible);
        }
        
        return map.get(n);
        
        
        
    }
}
