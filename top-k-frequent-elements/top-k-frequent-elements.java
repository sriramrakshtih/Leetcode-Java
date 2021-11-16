class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );
        for(int i : map.keySet()){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        
        int [] result = new int [pq.size()];
        for(int i = k-1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }
}