class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int j = nums.length - 1;
        int max = 0;
        int numMax = nums[0];
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length / 2; i++){
            int sum = nums[i] + nums[j];
            numMax = Math.max(numMax, sum);
            max = Math.max(numMax, max);
            j--;
        }
        return max;
    }
}