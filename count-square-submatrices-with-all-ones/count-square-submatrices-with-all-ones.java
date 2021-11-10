class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] dp = new int [m][n];
        
        for(int i =0; i < m; i++) {
            if(matrix[i][0] == 1){
                dp[i][0] = 1;
                //count++;
            }
                
        }
        
        for(int i =0; i < n; i++) {
            if(matrix[0][i] == 1)
                dp[0][i] = 1;
        }
        
        
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 1){
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        
        // System.out.print(Arrays.deepToString(dp));
        
        int count = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                count += dp[i][j];
            }
        }
        return count;
    }
    
}