class Solution {
    public int maxProfit(int[] prices) {
        int maProfit = 0;
        int buy = prices[0];
        for(int i = 1; i < prices.length; i++) {
            maProfit = Math.max(prices[i] - buy, maProfit);
            buy = Math.min(buy, prices[i]);
        }
        return maProfit;
    }
}