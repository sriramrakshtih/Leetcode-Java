class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MAX_VALUE;
        int low = 1;
        int high = 0;
        
        for(int weight : weights) {
            high += weight;
        }
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(isValid(weights, mid) <= days) {
                high = mid - 1;
                min = Math.min(mid, min);
            } else {
                low = mid + 1;
            }
        }
        
        return min;
    }
    
    private int isValid(int [] weights, int capacity) {
        int days = 1;
        int total = 0;
        for(int i = 0; i < weights.length; i++) {
            if(weights[i] > capacity) return Integer.MAX_VALUE;
            total += weights[i];
            if(total > capacity) {
                days++;
                total = weights[i];
            }
        }
        
        return days;
    }
}