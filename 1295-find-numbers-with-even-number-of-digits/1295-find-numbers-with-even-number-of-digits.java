class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums){
            int digitCount = 0;
            while(num > 0) {
                digitCount++;
                num = num / 10;
            }
            if(digitCount % 2 == 0){
                count++;
            }
        }
        return count;
    }
}