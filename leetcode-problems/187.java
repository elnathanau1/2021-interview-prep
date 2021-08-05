// https://leetcode.com/problems/repeated-dna-sequences/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> returnList = new ArrayList<>();
        
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String temp = s.substring(i, i+10);
            if (counts.containsKey(temp)) {
                if (counts.get(temp) == 1) {
                    returnList.add(temp);
                }
            }
            counts.put(temp, counts.getOrDefault(temp, 0) + 1);
        }
        
        return returnList;
    }
}
