class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int numWays(int n, int k) {
        return totalWays(n, k);
        
    }
    
    private int totalWays(int i, int k) {
        if(i == 1) {
            return k;
        }
        
        if(i == 2) {
            return k * k;
        }
        
        if(map.containsKey(i)) {
            return map.get(i);
        } 
        map.put(i, (k-1) * (totalWays(i-1, k) + totalWays(i-2, k))) ;
        return map.get(i);
        
    }
}