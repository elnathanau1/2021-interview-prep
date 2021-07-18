// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int longestSubstringLength = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        int low = 0;
        int high = 0;
        
        char[] sArr = s.toCharArray();
        charCount.put(sArr[0], 1);
        while (low <= sArr.length - 1) {
            if (charCount.keySet().size() <= k) {
                longestSubstringLength = Math.max(longestSubstringLength, high - low + 1);
                high++;
                if (high >= sArr.length) break;
                charCount.put(sArr[high], charCount.getOrDefault(sArr[high], 0) + 1);
            }
            else {
                int lowCount = charCount.get(sArr[low]);
                if (lowCount == 1) charCount.remove(sArr[low]);
                else charCount.put(sArr[low], charCount.get(sArr[low]) - 1);
                low++;
            }
        }
        
        return longestSubstringLength;
    }
}
