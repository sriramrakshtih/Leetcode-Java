class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int right = n-4;
        int left = 0;
        int i = 0;
        if(n <= 3){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        while(i <= 3){
            res = Math.min(res, nums[right] - nums[left]);
            left++;
            right++;
            i++;
        }
        return res;
    }
}