class Solution {
    int n;
    int m;
    boolean [][] visited;
    int [][] dirs;
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean [m][n];
        dirs = new int [][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        if(grid == null || grid.length == 0) return true;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                 if(!visited[i][j]){
                     if(dfs(grid, i, j, -1,-1, grid[i][j]))
                         return true;
                 }
            }
        }
       
        return false;
    }
    
    private boolean dfs(char[][] grid, int i, int j, int initRow, int initCol, char c) {
        //base cond
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != c)
            return false;
        if(visited[i][j])
            return true;
        //logic
        visited[i][j] = true;
        for(int [] dir : dirs) {
            int row = dir[0] + i;
            int col = dir[1] + j;
            if(row == initRow && col == initCol){
                continue;
            }
            if(dfs(grid, row, col, i, j, c))
                return true;
        }
        return false;
    }
}