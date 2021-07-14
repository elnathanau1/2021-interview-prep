// https://leetcode.com/problems/symmetric-tree/

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
    public boolean isSymmetric(TreeNode root) {
        Queue<Integer> leftRep = new LinkedList();
        
        Queue<TreeNode> queue = new LinkedList();
        
        // BFS going left then right
        queue.add(root.left);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                leftRep.add(null);
            }
            else {
                leftRep.add(node.val);
                
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        
        // queue empty again so reusing
        queue.add(root.right);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer mirrorValue = leftRep.poll();
            if (node == null) {
                if (mirrorValue != null) {
                    return false;
                }
            }
            else {
                if (mirrorValue == null || mirrorValue != node.val) {
                    return false;
                }
                
                queue.add(node.right);
                queue.add(node.left);
            }
        }
        
        if(leftRep.isEmpty()) {
            return true;
        }
        return false;
        
    }
}
