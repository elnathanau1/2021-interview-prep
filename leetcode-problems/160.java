// https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // using stack
        Stack<ListNode> stackA = new Stack();
        Stack<ListNode> stackB = new Stack();
        
        ListNode temp = headA;
        while (temp != null) {
            stackA.add(temp);
            temp = temp.next;
        }
        
        temp = headB;
        while (temp != null) {
            stackB.add(temp);
            temp = temp.next;
        }
        
        temp = null;
        while(!stackA.isEmpty() && !stackB.isEmpty()){
            if (stackA.peek().equals(stackB.peek())) {
                temp = stackA.pop();
                stackB.pop();
            }
            else {
                break;
            }
        }
        
        return temp;
        
    }
}
