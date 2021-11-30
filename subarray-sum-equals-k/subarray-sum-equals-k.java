class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, rSum = 0;
        map.put(0,1);
        for(int i = 0; i < nums.length; i++) {
            rSum += nums[i];
            int compliment = rSum - k;
            if(map.containsKey(compliment)) {
                count += map.get(compliment);
            }
            if(!map.containsKey(rSum)){
                map.put(rSum, 1);
            } else {
                map.put(rSum, map.get(rSum) + 1);
            }
        }
        
        return count;
    }
}