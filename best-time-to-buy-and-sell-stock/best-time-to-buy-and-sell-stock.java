class Solution {
    public int maxProfit(int[] prices) {
        
        int min = prices[0];
        int maxProfit = 0;
        if(prices == null) return maxProfit;
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }
    
}