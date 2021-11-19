class Solution {
    List<List<Integer>> res;
    List<Integer> sub = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        backtrack(candidates, target, 0);
        return res;
    }
    
    private void backtrack(int[] nums, int target, int index) {
        if(target == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }
        
        if(target < 0) return;
        
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) continue;
            sub.add(nums[i]);
            backtrack(nums, target - nums[i], i+1);
            sub.remove(sub.size() - 1);
        }
    }
}