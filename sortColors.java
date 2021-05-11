public class sortColors {
    private void swap(int[] nums, int x, int y){
        
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
        
    }
    
    public void sortColors1(int[] nums) {
        int low = 0; int high = nums.length - 1;
        int mid = 0;
        while(mid <= high) {
            if(nums[mid] == 1){
                mid++;
            } else if(nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            } else {
                swap(nums, mid, low);
                low++;
                mid++;
            }
        }
    }
}
