class Solution {
    class Pair {
        int first;
        int second;
        
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegree = new int [n+1];
        
        for(int i = 0; i < relations.length; i++){
            indegree[relations[i][1]]++;
        }
        
        
        for(int i = 0; i < relations.length; i++) {
            if(!map.containsKey(relations[i][0])){
                 map.put(relations[i][0], new ArrayList<>());
            }
            if(!map.containsKey(relations[i][1])){
                 map.put(relations[i][1], new ArrayList<>());
            }
            
            map.get(relations[i][0]).add(relations[i][1]);
        }
        
        //System.out.print(map);
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        for(int i = 1; i<=n; i++) {
            map2.put(i, 0);
        }
        
        Queue<Pair> q = new LinkedList<>();
        // System.out.print(Arrays.toString(indegree));
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0){
                Pair p = new Pair(i, time[i-1]);
                // System.out.println(p.first);
                // System.out.println(p.second);
                q.add(p);
            }
        }
        
        int max = 0;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            max = Math.max(max, p.second);
            
            List<Integer> children = map.getOrDefault(p.first, new ArrayList<>());
            
            for(int child : children) {
                map2.put(child, Math.max(map2.get(child), p.second));
                indegree[child]--;
                if(indegree[child] == 0) {
                    Pair pq = new Pair(child, map2.get(child)+time[child - 1]);
                    q.add(pq);
                }
            }
        }
        return max;
    }
}