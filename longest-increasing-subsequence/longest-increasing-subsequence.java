class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);    
                }
                
            }
        }
        int res = 0;
        for(int i : arr) {
            res = Math.max(res,i);
        }
        return res;
    }
}