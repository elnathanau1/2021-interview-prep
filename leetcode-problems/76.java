// https://leetcode.com/problems/minimum-window-substring/

class Node {
    char c;
    int index;
    int numToNext;
    
    public Node(char c, int index) {
        this.c = c;
        this.index = index;
        this.numToNext = 0;
    }
    
    public void incrementNumToNext() { this.numToNext++; }
}

class Solution {
    public String minWindow(String s, String t) {
        // O(n)
        Map<Character, Integer> charOccur = new HashMap<>();
        for (char c : t.toCharArray()) charOccur.put(c, charOccur.getOrDefault(c, 0) + 1);
        
        List<Node> nodes = new ArrayList<>();
        Node tempNode = null;
        
        // O(m)
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            char c = sArray[i];
            
            if (charOccur.containsKey(c)) {
                if (tempNode == null) {
                    tempNode = new Node(c, i);
                }
                else {
                    nodes.add(tempNode);
                    tempNode = new Node(c, i);
                }
            }
            else {
                if (tempNode != null) tempNode.incrementNumToNext();
            }
        }
        if (tempNode != null) nodes.add(tempNode);
        
        int min = Integer.MAX_VALUE;
        int minLowIndex = 0;
        int minHighIndex = -1;
        
        int low = 0;
        int high = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        if (!nodes.isEmpty()) {
            charCount.put(nodes.get(0).c, 1);
        }
        
        while (low <= nodes.size() - t.length()) {
            int lowIndex = nodes.get(low).index;
            int highIndex = nodes.get(high).index;
            
            if (mapContains(charOccur, charCount)) {
                int length = highIndex - lowIndex;
                
                // min check
                if (length < min) {
                    min = length;
                    minLowIndex = lowIndex;
                    minHighIndex = highIndex;
                }
                
                // remove low value from charCount
                char lowC = nodes.get(low).c;
                charCount.put(lowC, charCount.get(lowC) - 1);
                low++;
            }
            else if(high == nodes.size() - 1) {
                // remove low value from charCount
                char lowC = nodes.get(low).c;
                charCount.put(lowC, charCount.get(lowC) - 1);
                low++;
            }
            else {
                high++;
                char highC = nodes.get(high).c;
                charCount.put(highC, charCount.getOrDefault(highC, 0) + 1);
            }
        }
        
        return s.substring(minLowIndex, minHighIndex + 1);
    }
    
    // O(n)
    public boolean mapContains(Map<Character, Integer> orig, Map<Character, Integer> test) {
        for (Character key : orig.keySet()) {
            if (orig.get(key) > test.getOrDefault(key, Integer.MIN_VALUE)) return false;
        }
        return true;
    }
}
