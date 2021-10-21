class Solution {
    int m; int n; int [][] dirs;
    public boolean exist(char[][] board, String word) {
        m = board.length; n = board[0].length;
        dirs = new int [][]{{0,1}, {0,-1}, {1,0},{-1,0}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char [][] board, String word, int i, int j, int index) {
        //base case
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#') return false;
        
        //logic
        if(word.charAt(index) == board[i][j]){
            char temp = board[i][j];
            board[i][j] = '#';
            for(int [] dir : dirs){
                int row = dir[0] + i;
                int col = dir[1] + j;
                if(dfs(board, word, row, col, index + 1)) return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
}