class Solution {
    boolean found;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        found = false;
        for(int i = 0 ; i < n ; i++){
            map.put(i, new ArrayList());
        }
        
        for(int[] edge : edges){
           map.get(edge[0]).add(edge[1]);
           map.get(edge[1]).add(edge[0]);
        }
        
        
        boolean [] visited = new boolean[n];
        List<Integer> children = map.get(start);
        
        dfs(map, visited, start, end);
            
        return found;
        
    }
    
    private void dfs(Map<Integer, List<Integer>> map, boolean [] visited, int start, int end) {
        //base case
        if(visited[start] || found) return;
        
        //logic
        visited[start] = true;
        for(int child : map.get(start)){
            if(child == end){
                found = true;
                break;
            }
            if(!visited[child]){
                dfs(map, visited, child, end);
            }
            
        }
    }
}