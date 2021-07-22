// https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        for (int i = 0 ; i < minCost.length; i++) {
            if (i == 0 || i == 1) minCost[i] = cost[i];
            else if (i < cost.length) minCost[i] = Math.min(minCost[i-1], minCost[i-2]) + cost[i];
            else minCost[i] = Math.min(minCost[i-1], minCost[i-2]);
        }
        
        return minCost[minCost.length - 1];
    }
}
