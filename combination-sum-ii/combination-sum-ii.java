class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
    
    private void backtrack(int[] candidates, int target, int currSum, List<Integer> temp, int index) {
        
        if(currSum == target){
            res.add(new ArrayList<>(temp));   
            return;
        }
        
        if(currSum > target) return;
        
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) continue;
    
            temp.add(candidates[i]);
            backtrack(candidates, target, currSum+candidates[i], temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
}