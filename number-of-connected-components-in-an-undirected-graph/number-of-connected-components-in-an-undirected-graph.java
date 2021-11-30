class Solution {
    HashMap<Integer, List<Integer>> map;
    public int countComponents(int n, int[][] edges) {
        map = new HashMap<>();
        int count = 0;
        for(int [] edge : edges) {
            if(!map.containsKey(edge[0])){
                map.put(edge[0], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)){
                count++;
                dfs(i, visited);
            }
        }
        return count;
    }
    
    private void dfs(int edge, HashSet<Integer> visited) {
        visited.add(edge);
        List<Integer> li = map.get(edge);
        if(li != null) {
            for(int nei : li) {
                if(!visited.contains(nei)) {
                    dfs(nei, visited);
                }
            }
        }
        
    }
}