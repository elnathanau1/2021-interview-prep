// https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        
        int max = Integer.MIN_VALUE;
        int low = 0;
        int high = 0;
        map.put(sArr[0], 1);
        
        while (low <= sArr.length - 1) {
            if (valid(map, k)) {
                max = Math.max(max, high - low + 1);
                if (high >= sArr.length - 1) break;
                high++;
                map.put(sArr[high], map.getOrDefault(sArr[high], 0) + 1);
            }
            else {
                if (map.get(sArr[low]) == 1) map.remove(sArr[low]);
                else map.put(sArr[low], map.get(sArr[low]) - 1);
                low++;
            }
        }
        
        return max;
    }
    
    private boolean valid(Map<Character, Integer> map, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (Integer i : map.values()) {
            sum += i;
            max = Math.max(max, i);
        }
        
        return (sum - max <= k);
    }
}
