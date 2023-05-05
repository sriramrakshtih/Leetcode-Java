class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length < 2) return -1;
        Arrays.sort(nums);
        int res = (nums[nums.length-1]-1) * (nums[nums.length-2]-1);
        return res;
    }
}