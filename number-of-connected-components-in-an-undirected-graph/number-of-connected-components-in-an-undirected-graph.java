class Solution {
    HashMap<Integer, List<Integer>> map;
    int [] visited;
    public int countComponents(int n, int[][] edges) {
        map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < edges.length;i++){
            if(!map.containsKey(edges[i][0])){
                map.put(edges[i][0], new ArrayList<>());
            }
            if(!map.containsKey(edges[i][1])){
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        
        visited = new int [n];
        
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                count++;
                dfs(i);
                
            }
        }
        return count;
    }
    
    private void dfs(int start){
        visited[start] = 1;
        List<Integer> li = map.get(start);
        if(li != null){
            for(int i : li){
                if(visited[i] == 0){
                    dfs(i);
                }
            }    
        }
    }
}