class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int []> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int i = 1, k = 0; i < intervals.length; i++){
            
            if(intervals[i][0] <= res.get(k)[1]){
                res.get(k)[1] = Math.max(res.get(k)[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
                k++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}