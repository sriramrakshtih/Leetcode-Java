class Solution {
    
    public class Pair {
        int first;
        int second;
        
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    
    
    public int minimumTime(int n, int[][] relations, int[] time) {
        
        int [] indegree = new int[n+1];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Arrays.fill(indegree, 0);
        
        for(int i = 0; i < relations.length; i++){
            indegree[relations[i][1]]++;
        }
        
        for(int i = 0; i < relations.length; i++) {
            
            if(!map.containsKey(relations[i][1])){
                map.put(relations[i][1], new ArrayList<>());
            }
            if(!map.containsKey(relations[i][0])){
                map.put(relations[i][0], new ArrayList<>());
            }
            map.get(relations[i][0]).add(relations[i][1]);
        }
        
        // System.out.print(map);
        //System.out.print(Arrays.toString(indegree));
        
        Queue<Pair> q = new LinkedList<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i = 1; i <= n; i++){
            map2.put(i, 0);
        }
        
        
        for(int i = 1, j = 0; i < indegree.length; i++,j++){
            if(indegree[i] == 0){
                Pair p = new Pair(i, time[j]);
                q.add(p);
            }
        }
        
        List<Integer> li = new ArrayList<>();
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            li.add(p.second);
            List<Integer> children = map.getOrDefault(p.first, new ArrayList<>());
            
            for(int child : children){
                map2.put(child, Math.max(map2.get(child),p.second));
                indegree[child]--;
                if(indegree[child] == 0){
                    Pair pq = new Pair(child, map2.get(child)+time[child-1]);
                    q.add(pq);
                }
            }
            
        }
        int max = 0;
        for(int i = 0; i < li.size(); i++) {
            //System.out.println(li.get(i));
            max = Math.max(max, li.get(i));
        }
        return max;
    }
}