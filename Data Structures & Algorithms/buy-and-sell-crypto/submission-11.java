class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int l = 0;
        int r = l + 1;

        int maxProfit = 0;

        while (r < prices.length) {
            int profit = prices[r] - prices[l];
            maxProfit = Math.max(profit, maxProfit);

            if (prices[r] < prices[l]) {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}
