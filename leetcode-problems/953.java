// https://leetcode.com/problems/verifying-an-alien-dictionary/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        char[] letters = order.toCharArray();
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            index.put(letters[i], i);
        }
        
        if (words.length == 1) return true;
        for (int i = 0; i < words.length - 1; i++){
            if (!smallerThan(words[i], words[i+1], index)) return false;
        }
        
        return true;
    }
    
    public boolean smallerThan(String a, String b, Map<Character, Integer> index) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        
        for (int i = 0; i < Math.min(aArr.length, bArr.length); i++) {
            if (index.get(aArr[i]) < index.get(bArr[i])) return true;
            else if (index.get(aArr[i]) > index.get(bArr[i])) return false;
        }
        
        return (aArr.length <= bArr.length);
    }
}
