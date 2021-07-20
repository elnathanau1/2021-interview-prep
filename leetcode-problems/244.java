// https://leetcode.com/problems/shortest-word-distance-ii/

class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        
        for (int i = 0; i < wordsDict.length; i++) {
            String s = wordsDict[i];
            if (map.containsKey(s)) map.get(s).add(i); // because we're processing left to right, they'll be in order
            else map.put(s, new ArrayList(Arrays.asList(i)));
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);
        
        int smallest = Integer.MAX_VALUE;
        
        int index1 = 0;
        int index2 = 0;
        
        while (index1 < word1List.size() && index2 < word2List.size()) {
            int diff = word1List.get(index1) - word2List.get(index2);
            smallest = Math.min(smallest, Math.abs(diff));
            
            if (diff > 0 || index1 == word1List.size() - 1) index2++;
            else if (diff < 0 || index2 == word2List.size() - 1) index1++;
            else break;
        }
        
        return smallest;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
