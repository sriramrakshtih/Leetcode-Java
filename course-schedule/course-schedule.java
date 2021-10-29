class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] indegree = new int [numCourses];
        
        
        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);    
            }
        }
        
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> list = map.get(curr);
            if(list != null){
                for(int child : list){
                    indegree[child]--;
                    if(indegree[child] == 0){
                        q.add(child);
                    }
                }
            }
            
        }
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] != 0){
                return false;
            }
        }
        //System.out.print(Arrays.toString(indegree));
        return true;
    }
}