// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Pair {
    Node node;
    int depth;
    public Pair(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class Solution {
    public Node connect(Node root) {
        Queue<Pair> queue = new LinkedList();
        if (root != null) queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node currNode = pair.node;
            int depth = pair.depth;
            
            if (!queue.isEmpty()) {
                pair = queue.peek();
                Node nextNode = pair.node;
                int nextDepth = pair.depth;
                if (depth == nextDepth) currNode.next = nextNode;
            }
            
            if (currNode.left != null) queue.add(new Pair(currNode.left, depth + 1));
            if (currNode.right != null) queue.add(new Pair(currNode.right, depth + 1));
            
        }
        
        return root;
    }
}
