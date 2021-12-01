class Solution {
    public int rob(int[] nums) {
        int skip = 0; int loot = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = skip;
            
            skip = Math.max(temp, loot);
            loot = nums[i] + temp;
        }
        return Math.max(loot, skip);
    }
}