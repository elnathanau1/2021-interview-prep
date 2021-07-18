// https://leetcode.com/problems/diameter-of-binary-tree/

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
    int maxDiameter = Integer.MIN_VALUE;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }
    
    private int maxDepth(TreeNode root) {
        int leftSum = (root.left != null) ? maxDepth(root.left) : 0;
        int rightSum = (root.right != null) ? maxDepth(root.right) : 0;
        int maxSum = Math.max(leftSum, rightSum);
        
        maxDiameter = Math.max(maxDiameter, leftSum + rightSum);
        
        return maxSum + 1;
        
    }
}
