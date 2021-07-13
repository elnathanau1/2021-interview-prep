// https://leetcode.com/problems/shortest-word-distance/
// Brute Force Solution
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++){
            String target = "";
            boolean found = false;
            if (wordsDict[i].equals(word1)) {
                target = word2;
                found = true;
            }
            else if (wordsDict[i].equals(word2)) {
                target = word1;
                found = true;
            }
            
            if(found) {
                for (int j = i; j < wordsDict.length; j++) {
                    if (wordsDict[j].equals(target)) {
                        int distance = j - i;
                        if(distance < shortestDistance) {
                            shortestDistance = distance;
                        }
                        break;
                    } 
                }
            }
        }
        return shortestDistance;
    }
}


// VERY BAD Breadth First Search Solution
class Node {
    int index;
    String word;
    int depth;
    public Node(int index, String word, int depth) {
        this.index = index;
        this.word = word;
        this.depth = depth;
    }
}

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        // create nodes, mark the first
        List<Node> startNodes = new ArrayList();
        for (int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)) {
                startNodes.add(new Node(i, word1, 0));
            }
        }
        
        int distance = Integer.MAX_VALUE;
        for (Node startNode : startNodes) {
            int tempDist = findDistance(wordsDict, startNode, word2);
            if(tempDist < distance) {
                distance = tempDist;
            }
        }
        
        return distance;
        
    }
    
    private int findDistance(String[] wordsDict, Node startNode, String endWord) {
        
        // set up BFS
        Queue<Node> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        queue.add(startNode);
        
        // start algo
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited.add(node.index);
            if (node.word.equals(endWord)) {
                return node.depth;
            }
            int left = node.index - 1;
            int right = node.index + 1;
            if (left >= 0 && !visited.contains(left)) {
                queue.add(new Node(left, wordsDict[left], node.depth + 1));
            }
            
            if (right < wordsDict.length && !visited.contains(right)) {
                queue.add(new Node(right, wordsDict[right], node.depth + 1));
            }
        }
        
        return -1;
    }
}
