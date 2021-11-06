class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int [] dp = new int [envelopes.length];
        int max = 1;
        Arrays.sort(envelopes, (a,b) -> a[0]-b[0]);
        Arrays.fill(dp, 1);
        for(int i = 0; i < envelopes.length; i++){
            for(int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}