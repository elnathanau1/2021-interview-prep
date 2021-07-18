// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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
    List<Integer> inOrder = new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return inOrder.get(k - 1);
    }
    
    private void traverse(TreeNode root, int k) {
        if (root.left != null) traverse(root.left, k);
        if (inOrder.size() < k) inOrder.add(root.val);
        else return;
        if (root.right != null) traverse(root.right, k);
    }
}
