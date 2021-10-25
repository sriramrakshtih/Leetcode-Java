class Solution {
    int max = 0;
    List<List<Integer>> list = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    public int countHighestScoreNodes(int[] parents) {
        for(int i = 0; i < parents.length; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < parents.length; i++){
            if(parents[i] == -1) continue;
            else list.get(parents[i]).add(i);
        }
        dfs(0); 
        System.out.print(map);
        long max = 0;
        int count = 0;
        
        for(int i = 0; i < parents.length; i++) {
            long prod = 0;
            long a = 1;
            long b = 1;
            long c = 1;
            List<Integer> li = list.get(i);
            if(li != null){
                if(li.size() > 0){
                    a = map.get(li.get(0));
                }
                if(li.size() > 1){
                   b = map.get(li.get(1)); 
                }
            }
            if(i != 0){
                c = map.get(0)-map.get(i);
            }
            prod = a * b * c;
            
            if(prod == max) count++;
            if(prod > max) {
                count = 1;
                max = prod; 
            }
        }
        return count; 
    }
    
    private int dfs(int root) {
        int sum = 1;
        for(int i : list.get(root)){
            int res = dfs(i);
            sum += res;
        }
        map.put(root, sum);
        
        return sum;
    }
}