class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int [][] dirs = new int [][]{{0,-1}, {0,1}, {1,0}, {-1, 0}};
        int [][] newMat = new int [mat.length][mat[0].length];
        Queue<int []> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                } else {
                    newMat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int [] s : dirs) System.out.println(Arrays.toString(s));
        
        while(!q.isEmpty()){
            int [] curr = q.poll();
            
            for(int [] dir : dirs){
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];
                
                if(newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length){
                    if(newMat[curr[0]][curr[1]]  +1 < newMat[newX][newY]){
                        newMat[newX][newY] = newMat[curr[0]][curr[1]] + 1;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return newMat;
    }
}