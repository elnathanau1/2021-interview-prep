// https://leetcode.com/problems/max-stack/

class MaxList {
    List<Integer> list;
    
    public MaxList() {
        list = new ArrayList();
    }
    
    public void insert(int i) {
        if (list.isEmpty()) {
            list.add(i);
        }
        else {
            list.add(binarySearch(i),i);
        }
    }
    
    private int binarySearch(int i){
        int a = 0;
        int b = list.size();
        while (a != b) {
            int midpoint = (a + b)/2;
            int midpointVal = list.get(midpoint);
            if (midpointVal == i) {
                a = midpoint;
                break;
            }
            else if (midpointVal < i) {
                a = midpoint + 1;
            }
            else {
                b = midpoint;
            }
        }
        return a;
    }
    
    public void remove(int i) {
        list.remove(binarySearch(i));
    }
    
    public int peek() {
        return list.isEmpty() ? -1 : list.get(list.size() - 1);
    }
    public int pop() {
        return list.remove(list.size() - 1);
    }
}

class MaxStack {
    Stack<Integer> stack;
    MaxList maxes;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack();
        maxes = new MaxList();
    }
    
    public void push(int x) {
        stack.add(x);
        maxes.insert(x);
    }
    
    public int pop() {
        int topVal = stack.pop();
        maxes.remove(topVal);
        return topVal;
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int peekMax() {
        return maxes.peek();
        
    }
    
    public int popMax() {
        int max = maxes.pop();
        Stack<Integer> tempStack = new Stack();
        
        boolean found = false;
        while (!found) {
            int top = stack.pop();
            if (top == max) {
                found = true;
            }
            else {
                tempStack.add(top);
            }
        }
        
        while (!tempStack.isEmpty()) {
            stack.add(tempStack.pop());
        }
        
        return max;
        
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
