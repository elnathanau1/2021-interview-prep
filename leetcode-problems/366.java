// https://leetcode.com/problems/find-leaves-of-binary-tree/solution/

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
  
    List<List<Integer>> solution;
    public List<List<Integer>> findLeaves(TreeNode root) {
        solution = new ArrayList<>();
        getDepth(root);
        return solution;
    }
    
    private int getDepth(TreeNode root) {
        int leftDepth = (root.left != null) ? getDepth(root.left) : -1;
        int rightDepth = (root.right != null) ? getDepth(root.right) : -1;
        int depth = Math.max(leftDepth, rightDepth) + 1;
        if (depth > solution.size() - 1) solution.add(new ArrayList<>(Arrays.asList(root.val)));
        else solution.get(depth).add(root.val);
        return depth;
    }
}
