class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        
        int l = 0, r = l + 1;

        while (r < prices.length) {    
            int profit = prices[r] - prices[l];
            maxProfit = Math.max(maxProfit, profit);

            if (prices[r] < prices[l]) {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}
