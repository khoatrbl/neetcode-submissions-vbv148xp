class Solution {
    public int maxProfit(int[] prices) {
        // O(n^2)
        // int maxProfit = 0;

        // for (int i = 0; i < prices.length; i++) {
        //     for (int j = i + 1; j < prices.length; j++) {
        //         int currentProfit = prices[j] - prices[i];

        //         if (currentProfit > maxProfit) {
        //             maxProfit = currentProfit;
        //         }
        //     }
        // }

        // return maxProfit;


        int maxProfit = 0;

        int left = 0;
        int right = 1;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int currentProfit = prices[right] - prices[left];

                maxProfit = Math.max(currentProfit, maxProfit);
            } else {
                left = right;
                
            }
            right++;
        }        

        return maxProfit;

        
    }
}
