// https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 != 0) return new ArrayList<>();
        
        int jumbo = tomatoSlices / 2 - cheeseSlices;
        int small = cheeseSlices - jumbo;
        
        if (jumbo < 0 || small < 0) return new ArrayList<>();
        return Arrays.asList(jumbo, small);
    }
}
