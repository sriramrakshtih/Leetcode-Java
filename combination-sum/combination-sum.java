class Solution {
    List<List<Integer>> res;
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(candidates, target, 0);
        return res;
    }
    
    private void backtrack(int [] nums, int target, int index) {
        if(target == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }
        
        if(target < 0) return;
        
        for(int i = index; i < nums.length; i++) {
            sub.add(nums[i]);
            backtrack(nums, target - nums[i], i);
            sub.remove(sub.size()-1);
        }
    }
}