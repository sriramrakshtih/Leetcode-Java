class twoSum {
    public int[] twoSum1(int[] nums, int target) {
        int start = 0; int end = nums.length - 1;
        while(start < end) {
            if(nums[start] + nums[end] == target) {
                return new int[] {start, end};
            } else if(nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        throw new IllegalArgumentException("not found");
    }
}