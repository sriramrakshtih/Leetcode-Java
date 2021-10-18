class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges == null || edges.length == 0) return n == 1;
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int [] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        if(dfs(edges[0][0], -1) && set.size() == n){
            return true;
        }
        
        
        return false;
    }
    private boolean dfs(int curr, int parent){
        if(set.contains(curr)){
            return false;
        }
        
        set.add(curr);
        for(int i : adj.get(curr)){
            if(parent != i){
                if(!dfs(i, curr)){
                    return false;
                }
            }
        }
        return true;
    }
}