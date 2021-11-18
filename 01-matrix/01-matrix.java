class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int [][] newMat = new int[mat.length][mat[0].length];
        
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new int []{i,j});
                } else {
                    newMat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int [][] dirs = new int [][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        while(!q.isEmpty()) {
            int [] curr = q.poll();
            
            for(int[] dir : dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                
                if(row >= 0 && row < newMat.length && col >= 0 && col < newMat[0].length) {
                    if(newMat[curr[0]][curr[1]] + 1 < newMat[row][col]){
                        newMat[row][col] = newMat[curr[0]][curr[1]] + 1;
                        q.offer(new int[]{row, col});
                    }
                }
            }
        }
        return newMat;
    }
}