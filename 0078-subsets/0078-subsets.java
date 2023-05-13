class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    
    private void backtrack(int [] nums, int index, List<Integer> sub) {
        res.add(sub);
        for(int i = index; i < nums.length; i++){
            List<Integer> temp = new ArrayList<>(sub);
            //action
            sub.add(nums[i]);
            //recurrse
            backtrack(nums, i + 1, temp);
            //backtrack
            // sub.remove(sub.size()-1);
        }
    }
}