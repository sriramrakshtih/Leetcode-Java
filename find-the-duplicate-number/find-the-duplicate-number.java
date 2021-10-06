class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        
        int fast = nums[0]; int slow = nums[0];
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while(fast != slow);
        
        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
    }
}