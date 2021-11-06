class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] arr = new int [nums.length];
        int len = 0;
        arr[0] = nums[0];
        len++;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > arr[len-1]){
                arr[len] = nums[i];
                len++;
            } else {
                int bsIndex = binarySearch(arr, 0, len-1, nums[i]);
                arr[bsIndex] = nums[i];
            }
        }
        return len;
    }
    
    private int binarySearch(int [] nums, int low, int high, int target) {
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}