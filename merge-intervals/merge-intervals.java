class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int [0][0];
        List<int []> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> {
           if(a[0] == b[0]){
               return a[1] - b[1];
           } 
            return a[0]-b[0];
        });
        
        res.add(intervals[0]);
        for(int i = 1, k = 0; i < intervals.length; i++) {
            if(intervals[i][0] <= res.get(k)[1]){
                res.get(k)[1] = Math.max(intervals[i][1], res.get(k)[1]);
            } else {
                res.add(intervals[i]);
                k++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}