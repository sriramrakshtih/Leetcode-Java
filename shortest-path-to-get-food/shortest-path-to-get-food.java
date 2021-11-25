class Solution {
    // public int getFood(char[][] grid) {
//         int m = grid.length; int n = grid[0].length;
//         if(grid == null || m == 0) return -1;
//         boolean [][] visited = new boolean[m][n];
//         Queue<int []> q = new LinkedList<>();
        
//         for(int i = 0; i < m; i++) {
//             for(int j = 0; j < n; j++) {
//                 if(grid[i][j] == '*'){
//                     q.add(new int[]{i, j});
//                 }
//             }
//         }
        
//         int steps = 0;
//         int [][] dirs = new int [][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
        
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i = 0; i < size; i++) {
//                 int [] curr = q.poll();
                
//                 int row = curr[0];
//                 int col = curr[1];
                
                
//                 if(grid[row][col] == '#') return steps;
                
//                 for(int [] dir : dirs) {
//                     int newRow = row + dir[0];
//                     int newCol = col + dir[1];
                    
//                     if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] != 'X' && !visited[newRow][newCol]){
//                         visited[row][col] = true;
//                         q.add(new int []{newRow, newCol});
//                     }
//                 }
//             }
            
//             steps++;
//         }
        
//         return -1;
//     }
    
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int getFood(char[][] grid) {
        int n = grid.length, m = grid[0].length, steps = 0;
        boolean[][] seen = new boolean[n][m];
        Queue<int[]> q = new LinkedList();
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(grid[i][j] == '*')
                    q.add(new int[]{i , j});
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] index = q.poll();
                int row = index[0], col = index[1];
                
                if(grid[row][col] == '#') return steps;
                
                for(int[] direction : directions){
                    int r = row + direction[0], c = col + direction[1];
                    if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] != 'X' && !seen[r][c]){
                         seen[r][c] = true;
                         q.add(new int[]{r , c});
                    }
                    
                } 
            }
            steps++;
        }
        return -1;
    }
}