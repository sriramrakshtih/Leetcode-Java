class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1; int high = (int)1e6;
        while(low < high) {
            int mid = low + (high - low) / 2;
            int sum = 0;
            for(int i : nums) {
                sum += (i + mid - 1) / mid;
            }
            if(sum <= threshold){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}