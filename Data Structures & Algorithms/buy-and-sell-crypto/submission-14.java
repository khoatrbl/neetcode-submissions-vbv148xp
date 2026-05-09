class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int l = 0;
        
        for (int r = l + 1; r < prices.length; r++) {
            if (prices[r] < prices[l]) {
                l = r;
                continue;
            }
            int profit = prices[r] - prices[l];
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }
}
