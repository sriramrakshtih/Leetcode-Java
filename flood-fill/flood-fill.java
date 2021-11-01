class Solution {
    int currVal;
    int m; int n;
    int newC;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0) return image;
        currVal = image[sr][sc];
        m = image.length;
        n = image[0].length;
        newC = newColor;
        if(image[sr][sc] == newColor) return image;
        dfs(sr, sc, image);
        return image;
    }
    
    private void dfs(int i , int j, int [][] image){
        if(i < 0 || j < 0 || i >= m || j >= n || image[i][j] != currVal) return;
        
        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        image[i][j] = newC;
        for(int [] dir : dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            dfs(row, col, image);
        }
        return;
    }
}