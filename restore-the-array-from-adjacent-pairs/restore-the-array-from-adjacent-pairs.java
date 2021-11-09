class Solution {
    HashMap<Integer, List<Integer>> map;
    HashSet<Integer> visited;
    List<Integer> li = new ArrayList<>();
    
    public int[] restoreArray(int[][] adjacentPairs) {
        map = new HashMap<>();
        visited = new HashSet<>();
        
        for(int i = 0; i < adjacentPairs.length; i++) {
            if(!map.containsKey(adjacentPairs[i][0])){
                map.put(adjacentPairs[i][0], new ArrayList<>());
            }
            if(!map.containsKey(adjacentPairs[i][1])){
                map.put(adjacentPairs[i][1], new ArrayList<>());
            }
            map.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            map.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        
        int start = 0;
        for(int i : map.keySet()){
            if(map.get(i).size() == 1){
                start = i;
            }
        }
        
        dfs(start);
        
        int [] res = new int[li.size()];
        for(int i = 0; i < li.size(); i++) {
            res[i] = li.get(i);
        }
        
        return res;
    }
    
    private void dfs(int start) {
        li.add(start);
        visited.add(start);
        
        List<Integer> children = map.get(start);
        for(int child : children) {
            if(!visited.contains(child)){
                dfs(child);
            }
        }
    }
}