class Solution {
    int [][] matrix;
    boolean [][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        this.matrix = grid;
        visited = new boolean [grid.length][grid[0].length];
        int res = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0;j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }
    
    private int dfs(int i, int j){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j] || matrix[i][j] == 0){
            return 0;
        }
        visited[i][j] = true;
        return (1 + dfs(i+1,j) + dfs(i-1, j) + dfs(i, j+1) + dfs(i, j-1));
    }
}