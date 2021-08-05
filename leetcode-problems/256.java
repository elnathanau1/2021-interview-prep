// https://leetcode.com/problems/paint-house/

class Solution {
    public int minCost(int[][] costs) {
        int[][] minCosts = new int[costs.length][3];
        minCosts[minCosts.length - 1][0] = costs[costs.length - 1][0];
        minCosts[minCosts.length - 1][1] = costs[costs.length - 1][1];
        minCosts[minCosts.length - 1][2] = costs[costs.length - 1][2];
        
        for (int i = minCosts.length - 2; i >= 0; i--) {
            minCosts[i][0] = costs[i][0] + Math.min(minCosts[i+1][1], minCosts[i+1][2]);
            minCosts[i][1] = costs[i][1] + Math.min(minCosts[i+1][0], minCosts[i+1][2]);
            minCosts[i][2] = costs[i][2] + Math.min(minCosts[i+1][0], minCosts[i+1][1]);
        }
        
        return Math.min(Math.min(minCosts[0][0], minCosts[0][1]), minCosts[0][2]);
    }
}
