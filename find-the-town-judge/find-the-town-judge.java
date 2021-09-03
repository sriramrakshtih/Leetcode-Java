class Solution {
    public int findJudge(int N, int[][] trust) {
        int [] indegrees = new int[N];
        for(int[] tr : trust){
            indegrees[tr[0]-1]--;
            indegrees[tr[1]-1]++;
        }
        
        for(int i = 0; i < N; i++){
            if(indegrees[i] == N-1){
                return i+1;
            }
        }
        return -1;
    }
}