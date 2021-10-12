class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return findGcd(nums[0], nums[nums.length-1]);
    }
    
    private int findGcd(int a, int b){
        if(a == 0){
            return b;
        }
        
       return findGcd(b%a, a);
    }
}