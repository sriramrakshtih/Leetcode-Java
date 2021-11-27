class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int low = i+1; int high = n-1;
            while(low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if(Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if(sum < target){
                    ++low;
                } else {
                    --high;
                }
            }
        }
        return target - diff;
    }
}