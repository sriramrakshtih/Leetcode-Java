class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int [] indegree = new int [numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1], new ArrayList<>());
            }
            if(!map.containsKey(prerequisites[i][0])){
                map.put(prerequisites[i][0], new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
//         System.out.println(Arrays.toString(indegree));
//         System.out.println(map);
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> li = map.get(curr);
            if(!visited.contains(curr)){
                res.add(curr);
                visited.add(curr);
                if(li != null) {
                    for(int i : li){
                        indegree[i]--;
                        if(indegree[i] == 0){
                            q.add(i);
                        }
                    }
                }
            } else {
                return new int[]{};
            }
        }
        
        int [] ans = new int [res.size()];
        if(res.size() != numCourses) return new int[]{};
        for(int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}