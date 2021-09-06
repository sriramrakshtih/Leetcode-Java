class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int [] arr = new int[60];
        //distributive property !!
        for(int t : time){
            if(t % 60 == 0){
                count += arr[0];
            } else {
                count += arr[60 - t % 60];
            }
            arr[t % 60]++;
        }
        return count;
        
    }
}
