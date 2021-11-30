class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] + a[1]) - (b[0] + b[1]));
        
        for(int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int [] {nums1[i], nums2[0], 0});
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < k && !pq.isEmpty(); i++) {
            int [] arr = pq.poll();
            res.add(List.of(arr[0], arr[1]));
            if(arr[2] < nums2.length - 1) {
                pq.add(new int [] {arr[0], nums2[arr[2] + 1], arr[2] + 1});
            }
        }
        
        return res;
    }
}