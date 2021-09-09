import java.util.HashMap;

class twoSumArray{
    public int[] twoSum(int [] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
    
}
