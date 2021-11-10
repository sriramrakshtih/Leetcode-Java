class Solution {
    List<List<Integer>> result;
    int target;
    int [][] gra;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        target = graph.length-1;
        gra = graph;
        if(graph == null || graph.length == 0) return result;
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        backtrack(0, temp);
        return result;
    }
    
    private void backtrack(int curr, List<Integer> temp){
        if(curr == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i : gra[curr]){
            temp.add(i);
            backtrack(i, temp);
            temp.remove(temp.size() - 1);
        }
    }
}