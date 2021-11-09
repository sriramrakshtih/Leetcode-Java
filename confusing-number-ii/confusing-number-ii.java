class Solution {
    HashMap<Integer, Integer> map;
    int count;
    public int confusingNumberII(int n) {
        count = 0;
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        
        dfs(n, 0);
        return count;
    }
    
    private void dfs(int n, long curr){
        if(isValid(curr)){
            count++;
        }
        
        for(Integer key : map.keySet()){
            long next = curr * 10 + key;
            if(next != 0 && next <= n){
                dfs(n, next);
            }
        }
    }
    
    private boolean isValid(long n){
        
        long res = 0;
        long curr = n;
        while(n > 0){
            res = res * 10 + map.get((int)n%10);
            n = n / 10;
        }
        return res != curr;
    }
}