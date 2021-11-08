class Solution {
    public void rotate(int[] nums, int k) {
        
        int left = 0; int right = nums.length-1;
        if(k >= nums.length){
            k %= nums.length;
        }
        
        rotateNums(nums, left, right);
        rotateNums(nums, left, k-1);
        rotateNums(nums, k, right);
        //System.out.print(Arrays.toString(nums));
        
        
    }
    
    private void swap(int [] nums,int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    private void rotateNums(int [] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++; right--;
        }
    }
}