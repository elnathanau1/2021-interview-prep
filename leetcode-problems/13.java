// https://leetcode.com/problems/roman-to-integer/

class Solution {
    public int romanToInt(String s) {
        // create map from char to int
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        // map of subtraction rules
        Map<Character, Set<Character>> subRules = new HashMap();
        subRules.put('I', new HashSet(Arrays.asList('V', 'X')));
        subRules.put('X', new HashSet(Arrays.asList('L', 'C')));
        subRules.put('C', new HashSet(Arrays.asList('D', 'M')));
        
        // start math 
        char[] charArray = s.toCharArray();
        int sum = 0;
        
        for (int i = 0; i < charArray.length; i++){
            int charValue = map.get(charArray[i]);
            // last char, can't be used to subtract
            if (i == charArray.length - 1) {
                sum += charValue;
            }
            else if(subRules.get(charArray[i]) != null && subRules.get(charArray[i]).contains(charArray[i+1])) {
                sum -= charValue;
            }
            else {
                sum += charValue;
            }
        }
        
        return sum;
    }
}
