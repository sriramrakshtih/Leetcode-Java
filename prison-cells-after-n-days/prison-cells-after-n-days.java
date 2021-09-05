class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        
        // cells[cells.length-1] = 0;
        if(N > 14) N = 1 + (N-1) % 14;
        
        if(N == 0) return cells;
        
        int[] next = new int[8];
        for(int i=0; i<8; i++) {
            if(i == 0 || i == 7) next[i] = 0;
            else next[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
        }
        
        return prisonAfterNDays(next, N-1);
    }
}