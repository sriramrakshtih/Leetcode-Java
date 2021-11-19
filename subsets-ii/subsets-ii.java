class Solution {
    List<List<Integer>> res;
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }
    
    private void backtrack(int [] nums, int index) {
        if(!res.contains(sub)){
            res.add(new ArrayList<>(sub));    
        }
        
        for(int i = index; i < nums.length; i++) {
            sub.add(nums[i]);
            backtrack(nums, i+1);
            sub.remove(sub.size()-1);
        }
    }
}