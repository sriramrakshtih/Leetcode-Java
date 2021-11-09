class Solution {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if(sum % 4 != 0) return false;
        int side = sum / 4;
        //Arrays.sort(nums, (a,b) -> b - a);
        return backtrack(nums, new int[4], 0, side);
    }
    
    private boolean backtrack(int [] nums, int [] square, int index, int side){
        if(index == nums.length){
            if(square[0] == side && square[1] == side && square[2] == side){
                return true;
            }
            return false;
        }
        
        for(int i = 0; i < square.length; i++) {
            if((square[i] + nums[index]) <= side){
                //action
                square[i] = square[i] + nums[index];
                //recurse
                if(backtrack(nums, square, index + 1, side)) return true;
                //backtrack
                square[i] = square[i] - nums[index]; 
            }
            
        }
        return false;
    }
}