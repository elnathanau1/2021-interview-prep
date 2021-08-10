// https://leetcode.com/problems/closest-binary-search-tree-value-ii/

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                double val = (Math.abs(target - a) - Math.abs(target - b));
                if (val > 0.0) return -1;
                if (val == 0.0) return 0;
                else return 1;
            }
        });
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (pq.size() < k || Math.abs(target - node.val) < Math.abs(target - pq.peek())) {
                pq.add(node.val);
                if (pq.size() > k) pq.poll();
            }
            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }
        
        List<Integer> values = new ArrayList<>();
        while (!pq.isEmpty()) {
            values.add(pq.poll());
        }
        
        return values;
        
    }
}
