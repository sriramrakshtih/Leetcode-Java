class Solution {
    public int findLucky(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        int maxCountNum = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getKey().equals(entry.getValue())){
                maxCountNum = Math.max(maxCountNum, entry.getKey());
            }
        }
        
        return maxCountNum;
    }
}