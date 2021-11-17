class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for(int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isValid(weights, mid) <= days){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int isValid(int [] weights, int capacity) {
        int count = 1;
        int total = 0;
        for(int i = 0; i < weights.length; i++) {
            total += weights[i];
            if(total > capacity) {
                count++;
                total = weights[i];
            }
        }
        return count;
    }
}