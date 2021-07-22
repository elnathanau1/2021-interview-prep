// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        
        int profit = 0;
        for(int i = 0; i <= prices.length - 2; i++) {
            if (prices[i+1] - prices[i] > 0) profit += prices[i+1] - prices[i]; 
        }
        
        return profit;
    }
}
