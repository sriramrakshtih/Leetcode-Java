class Solution {
    class Pair {
        private int first;
        private int second;
        
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        Queue<Pair> q = new LinkedList<>();
        int count = -1;
        int fresh = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j));
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        q.add(new Pair(-1, -1));
        
        int [][] dirs = {{0,1}, {1,0},{-1,0}, {0,-1}};
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            if(r == -1){
                count++;
                if(!q.isEmpty()){
                    q.add(new Pair(-1, -1));
                }
            } else {
                for(int [] dir : dirs){
                    int nRow = r + dir[0];
                    int nCol = c + dir[1];

                    if(nRow >=0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length){
                        if(grid[nRow][nCol] == 1){
                            grid[nRow][nCol] = 2;
                            fresh--;
                            q.add(new Pair(nRow, nCol));
                        }
                    }
                }
            }
        }
        return fresh == 0 ? count : -1;
    }
}