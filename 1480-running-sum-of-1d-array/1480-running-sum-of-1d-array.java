class Solution {
    public int[] runningSum(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        int runningSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            runningSum = runningSum + nums[i];
            nums[i] = runningSum;
        }
        return nums;
    }
}