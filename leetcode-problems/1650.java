// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

// stack
// class Solution {
//     public Node lowestCommonAncestor(Node p, Node q) {
//         Stack<Node> pNodes = new Stack<>();
//         Node temp = p;
//         pNodes.add(temp);
//         while (temp.parent != null) {
//             temp = temp.parent;
//             pNodes.add(temp);
//         }
            
//         Stack<Node> qNodes = new Stack<>();
//         temp = q;
//         qNodes.add(temp);
//         while (temp.parent != null) {
//             temp = temp.parent;
//             qNodes.add(temp);
//         }

//         Node lca = null;
//         while (!pNodes.isEmpty() && !qNodes.isEmpty()) {
//             if (pNodes.peek() == qNodes.peek()){
//                lca = pNodes.pop();
//                qNodes.pop(); 
//             }
//             else break;
//         }
        
//         return lca;
        
        
//     }
// }

// Intersection method
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node trackA = p;
        Node trackB = q;
        while (trackA != trackB) {
            trackA = (trackA == null) ? q : trackA.parent;
            trackB = (trackB == null) ? p : trackB.parent;
        }
        
        return trackA;
    }
}
