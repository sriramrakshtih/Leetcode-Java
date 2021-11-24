class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        
        //if(intervals == null || intervals.length == 0) return 0;
        pq.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++) {
            //int [] interval = pq.peek();
            if(intervals[i][0] >= pq.peek()){ 
                pq.poll();
            }
            
            pq.add(intervals[i][1]);
            
        }
        return pq.size();
    }
}