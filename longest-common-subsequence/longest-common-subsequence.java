class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        
        char [] c1 = text1.toCharArray();
        char [] c2 = text2.toCharArray();
        
        int m = c1.length;
        int n = c2.length;
        
        int [][] dp = new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if(c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}