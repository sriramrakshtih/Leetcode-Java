class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        int i = n-2;
        
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        
        if(i >= 0){
            int j = n-1;
            while(nums[i] >= nums[j]){
                j--;
            }
            swap(i, j, nums);
        }
        
        reverse(i+1, nums.length-1, nums);
    }
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int i, int j, int [] nums) {
        while(i < j){
            swap(i, j, nums);
            i++; j--;
        }
    }
}