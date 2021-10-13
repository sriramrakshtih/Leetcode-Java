class Solution {
    
    public int numIslands(char[][] grid) {
        int m = grid.length; int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char [][] grid, int i, int j) {
        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m = grid.length; int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        
        //logic
        grid[i][j] = '0';
        for(int[] dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid, r, c);
        }
    }
}