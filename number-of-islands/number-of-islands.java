class Solution {
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    int [][] dirs = {{0,1}, {1,0},{0,-1}, {-1,0}};
    private void dfs(char [][] grid, int i, int j, boolean[][] visited) {
        
        if(grid[i][j] == '0'){
            return;
        }
        
        for(int [] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1' && !visited[row][col] ) {
                visited[row][col] = true;
                dfs(grid, row, col, visited);
            }
        }
    }
    
}