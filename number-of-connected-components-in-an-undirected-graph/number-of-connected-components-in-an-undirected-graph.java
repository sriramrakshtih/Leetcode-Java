class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
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
        
        Stack<Integer> st = new Stack<>();
        int count=0;
        
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++) {
            
            if(!visited.contains(i)){
                st.push(i);
                count++;
            }
            while(!st.isEmpty()){
                int node = st.pop();
                visited.add(node);
                List<Integer> neighbours = map.get(node);
                if(neighbours != null){
                    for(int neighbour : neighbours){
                        if(!visited.contains(neighbour)){
                            st.push(neighbour);
                        }
                    }
                }
            }
        }
        return count;
    }
}