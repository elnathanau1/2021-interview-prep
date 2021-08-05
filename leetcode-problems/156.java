// https://leetcode.com/problems/binary-tree-upside-down/

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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
        else {
            TreeNode finalHead = upsideDownBinaryTree(root.left);
            TreeNode newHead = root.left;
            newHead.right = root;
            newHead.left = root.right;
            root.right = null;
            root.left = null;
            return finalHead;
        }
    }
}
