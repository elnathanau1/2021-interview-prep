// https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

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
    public int findSecondMinimumValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int secondSmallest = -1;
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > root.val){
                if (secondSmallest == -1) secondSmallest = node.val;
                else secondSmallest = Math.min(node.val, secondSmallest);
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            
        }
        
        return secondSmallest;
    }
}
