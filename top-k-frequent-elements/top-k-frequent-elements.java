class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(map);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->  map.get(a) - map.get(b));
        
        for(int num : map.keySet()) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] top = new int[k];
        for(int i = 0; i < k; ++i) {
            top[i] = pq.poll();
        }
        return top;
     }
}