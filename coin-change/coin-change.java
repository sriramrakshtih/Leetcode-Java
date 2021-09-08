class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        
        int[][] dp = new int[coins.length + 1][amount + 1];
        
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        
        for(int j = 1; j <= amount; j++) {
            dp[0][j] = 9999;
        }
        
        for(int i = 1; i <= coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - coins[i-1]] + 1);
                }
            }
        }
        
        int result = dp[coins.length][amount];

       if(result >= 9999) return -1;

       else return result;
        //return dp[coins.length][amount];
    }
}