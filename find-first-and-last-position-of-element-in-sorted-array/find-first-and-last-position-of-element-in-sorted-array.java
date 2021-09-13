class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int []{-1, -1};
        
        int left = search(nums, target, true);
        int right = search(nums, target, false);
        
        return new int []{left, right};
    }
    
    private int search(int [] nums, int target, boolean findFirst) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) /2;
            
            if(target < nums[mid]) {
                end = mid - 1;
            } else if(target > nums[mid]){
                start = mid + 1;
            } else {
                ans = mid;
                if(findFirst){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}