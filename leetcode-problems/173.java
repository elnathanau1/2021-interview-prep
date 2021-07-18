// https://leetcode.com/problems/binary-search-tree-iterator/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Queue<TreeNode> queue;
    
    public BSTIterator(TreeNode root) {
        queue = new LinkedList();
        if (root != null) addNode(root);
    }
    
    private void addNode(TreeNode node) {
        if (node.left != null) addNode(node.left);
        queue.add(node);
        if (node.right != null) addNode(node.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
        
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
