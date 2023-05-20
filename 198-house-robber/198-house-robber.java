class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int [] dp = new int [nums.length+1];
        dp[dp.length-1] = 0;
        dp[dp.length-2] = nums[nums.length - 1] ;
        for(int i = nums.length-2; i >= 0; i--) {
            dp[i] = Math.max(dp[i+1], dp[i+2] + nums[i]);
        }
        return dp[0];
    }
}