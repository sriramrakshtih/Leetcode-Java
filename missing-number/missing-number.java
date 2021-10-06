class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        //if(nums.length == 1) return 1;
        int n = nums.length;
        int[] arr = new int[n+1];
        for(int i =1; i < n+1; i++) {
            arr[nums[i-1]]++;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                return i;
            }
        }
        return -1;
    }
}