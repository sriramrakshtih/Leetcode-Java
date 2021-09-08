class Solution {
    public int rob(int[] nums) {
        int loot = 0; int skip = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = skip;
            
            //don't choose
            skip = Math.max(temp, loot);
            
            loot = nums[i] + temp;
        }
        
        return Math.max(skip, loot);
    }
}