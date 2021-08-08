// https://leetcode.com/problems/paint-house-ii/

class Solution {
    public int minCostII(int[][] costs) {
        int[][] minCosts = new int[costs.length][costs[0].length];
        
        int oldSmallest = Integer.MAX_VALUE;
        int oldSecondSmallest = Integer.MAX_VALUE;
        int oldSmallestIndex = -1;
        int oldSmallestIndex2 = -1;
        
        for (int i = minCosts.length - 1; i >= 0; i--) {
            int smallest = Integer.MAX_VALUE;
            int secondSmallest = Integer.MAX_VALUE;
            int smallestIndex = -1;
            int secondSmallestIndex = -1;
            
            for (int j = 0; j < costs[0].length; j++) {
                if (i == minCosts.length - 1) minCosts[i][j] = costs[i][j];
                else {
                    if (j == oldSmallestIndex) minCosts[i][j] = costs[i][j] + oldSecondSmallest;
                    else minCosts[i][j] = costs[i][j] + oldSmallest;
                }
                
                if (minCosts[i][j] < smallest) {
                    // move smallest to second smallest
                    secondSmallest = smallest;
                    smallestIndex = secondSmallestIndex;

                    // set new second smallest
                    smallest = minCosts[i][j];
                    smallestIndex = j;
                }
                else if (minCosts[i][j] < secondSmallest) {
                    secondSmallest = minCosts[i][j];
                    secondSmallestIndex = j;
                }
            }
            
            oldSmallest = smallest;
            oldSecondSmallest = secondSmallest;
            oldSmallestIndex = smallestIndex;
            oldSmallestIndex2 = secondSmallest;
        }
        
        return oldSmallest;
    }
}
