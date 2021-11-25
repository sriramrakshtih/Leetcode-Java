class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double [] arr = new double [nums.length - k + 1];
        double max = 0;
        double sum = 0, avg = 0;
        int left = 1; int right = k;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        avg = sum / k;
        max = avg;
        
        while(right < nums.length) {
            sum += nums[right];
            sum -= nums[left - 1];
            avg = sum / k;
            arr[left-1] = avg;
            max = Math.max(max, avg);
            right++;
            left++;
                
        }
        System.out.print(Arrays.toString(arr));
        return max;
    }
}