class Solution {
    public int maxProfit(int[] prices) {
        // sliding window

        int l = 0;
        int r = l + 1;

        int maxProfit = 0;

        while (r < prices.length) {
            if (prices[r] > prices[l]) {
                int profit = prices[r] - prices[l];

                maxProfit = Math.max(profit, maxProfit);
            } else {
                l = r;
            } 
            r++;
        }

        return maxProfit;
    }
}
