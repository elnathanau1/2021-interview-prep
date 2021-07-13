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
