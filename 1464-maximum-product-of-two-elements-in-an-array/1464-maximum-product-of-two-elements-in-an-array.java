class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length < 2) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int num : nums){
            pq.add(num);
        }
        int num1 = pq.poll()-1;
        int num2 = pq.poll()-1;
        int res = num1 * num2;
        return res;
    }
}